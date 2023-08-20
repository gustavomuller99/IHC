package com.conectadot.app.modules.novoeditaranimalabrigo.ui

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.conectadot.app.R
import com.conectadot.app.appcomponents.SharedPreferences
import com.conectadot.app.appcomponents.base.BaseActivity
import com.conectadot.app.appcomponents.room.Animal
import com.conectadot.app.databinding.ActivityNovoEditarAnimalAbrigoBinding
import com.conectadot.app.modules.novoeditaranimalabrigo.data.viewmodel.NovoEditarAnimalAbrigoVM


class NovoEditarAnimalAbrigoActivity :
    BaseActivity<ActivityNovoEditarAnimalAbrigoBinding>(R.layout.activity_novo_editar_animal_abrigo) {
    private val viewModel: NovoEditarAnimalAbrigoVM by viewModels()

    var showRationale = false
    var imageUri: Uri? = null

    companion object {
        const val IMAGE_RESULT_CODE = 0
        const val TAG: String = "NOVO_EDITAR_ANIMAL_ABRIGO_ACTIVITY"

        fun getIntent(context: Context, bundle: Bundle?): Intent {
            val destIntent = Intent(context, NovoEditarAnimalAbrigoActivity::class.java)
            destIntent.putExtra("bundle", bundle)
            return destIntent
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            IMAGE_RESULT_CODE -> {
                if (resultCode == RESULT_OK) {
                    data?.data?.let {
                        this.contentResolver.takePersistableUriPermission(
                            it,
                            Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION
                        )
                        imageUri = it
                        binding.tvImgLoaded.visibility = View.VISIBLE
                    }
                }
            }
        }
    }

    override fun onInitialized() {
        viewModel.navArguments = intent.extras?.getBundle("bundle")
        binding.novoEditarAnimalAbrigoVM = viewModel
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (hasPermissions(
                listOf(
                    Manifest.permission.READ_EXTERNAL_STORAGE
                )
            )
        ) {
            selectPicture()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var editingAnimal = false
        var animalID = 0

        viewModel.navArguments?.getInt("id", -1)?.let {
            viewModel.getAnimal(this, it)
            animalID = it
        }

        viewModel.currentAnimal.observe(this) {
            it?.let {

                Toast.makeText(this, it.name, Toast.LENGTH_SHORT).show()
                editingAnimal = true
                binding.txtAnimalName.setText(it.name)
                binding.txtAnimalSpecies.setText(it.species)
                binding.txtAnimalRace.setText(it.race)
                binding.txtAnimalAge.setText(it.age)
                binding.txtDetailsC.setText(it.detailsc)
                binding.txtDetailsV.setText(it.detailsv)
                when(it.size){
                    "pequeno" -> binding.rbPequeno.toggle()
                    "medio" -> binding.rbMdio.toggle()
                    else -> binding.rbGrande.toggle()
                }
            }
        }

        binding.btnGroupThirtyEight.setOnClickListener {

            if (hasPermissions(
                    listOf(
                        Manifest.permission.READ_EXTERNAL_STORAGE
                    )
                )
            ) {
                selectPicture()
            } else {

                if (showRationale) {
                    Toast.makeText(this, "Permissão precisa ser garantida!", Toast.LENGTH_SHORT).show()
                    showRationale = false
                }

                requestPermissions(
                    0,
                    listOf(
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                    )
                )
                showRationale = true
            }
        }

        binding.btnConfirm.setOnClickListener {

            if (binding.txtAnimalName.text.isEmpty()) {
                showToast("Informe o nome do animal.")
                return@setOnClickListener
            }

            if (binding.txtAnimalSpecies.text.isEmpty()) {
                showToast("Informe a espécie do animal.")
                return@setOnClickListener
            }

            if (binding.txtAnimalRace.text.isEmpty()) {
                showToast("Informe a raça do animal.")
                return@setOnClickListener
            }

            if (binding.txtAnimalAge.text.isEmpty()) {
                showToast("Informe a idade do animal.")
                return@setOnClickListener
            }

            if (binding.txtDetailsC.text.isEmpty() || binding.txtDetailsV.text.isEmpty()) {
                showToast("Informe detalhes de castração e vacina.")
                return@setOnClickListener
            }

            if (!binding.rbPequeno.isChecked && !binding.rbMdio.isChecked && !binding.rbGrande.isChecked) {
                showToast("Informe o porte do animal.")
                return@setOnClickListener
            }

            val porte = when {
                binding.rbPequeno.isChecked -> "pequeno"
                binding.rbMdio.isChecked -> "medio"
                else -> "grande"
            }

            if(editingAnimal){
                viewModel.updateAnimal(
                    this,
                    Animal(
                        name = binding.txtAnimalName.text.toString(),
                        species = binding.txtAnimalSpecies.text.toString(),
                        race = binding.txtAnimalRace.text.toString(),
                        age = binding.txtAnimalAge.text.toString(),
                        size = porte,
                        detailsc = binding.txtDetailsC.text.toString(),
                        detailsv = binding.txtDetailsV.text.toString(),
                        shelter = SharedPreferences.getLoggedId(),
                        image = imageUri?.toString()
                    ), animalID
                )
            }else{
                viewModel.addAnimal(
                    this,
                    Animal(
                        name = binding.txtAnimalName.text.toString(),
                        species = binding.txtAnimalSpecies.text.toString(),
                        race = binding.txtAnimalRace.text.toString(),
                        age = binding.txtAnimalAge.text.toString(),
                        size = porte,
                        detailsc = binding.txtDetailsC.text.toString(),
                        detailsv = binding.txtDetailsV.text.toString(),
                        shelter = SharedPreferences.getLoggedId(),
                        image = imageUri?.toString()
                    )
                )
            }
            finish()
        }
    }

    private fun selectPicture() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).setType("image/*")
        startActivityForResult(intent, IMAGE_RESULT_CODE)
    }

    private fun hasPermissions(permissions: List<String>): Boolean = permissions.all {
        this.checkSelfPermission(it) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermissions(requestCode: Int, permissions: List<String>) {
        this.requestPermissions(permissions.toTypedArray(), requestCode)
    }

    override fun setUpClicks() {
        binding.imageArrowleft.setOnClickListener {
            finish()
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT)
            .show()
    }
}
