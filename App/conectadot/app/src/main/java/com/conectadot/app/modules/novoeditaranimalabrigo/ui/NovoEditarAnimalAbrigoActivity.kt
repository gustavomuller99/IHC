package com.conectadot.app.modules.novoeditaranimalabrigo.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.conectadot.app.R
import com.conectadot.app.appcomponents.SharedPreferences
import com.conectadot.app.appcomponents.base.BaseActivity
import com.conectadot.app.appcomponents.room.Animal
import com.conectadot.app.databinding.ActivityNovoEditarAnimalAbrigoBinding
import com.conectadot.app.modules.login.ui.LoginActivity
import com.conectadot.app.modules.maisdetalhesabrigo.ui.MaisDetalhesAbrigoActivity
import com.conectadot.app.modules.novoeditaranimalabrigo.`data`.viewmodel.NovoEditarAnimalAbrigoVM
import com.conectadot.app.modules.telaprincipalabrigo.ui.TelaPrincipalAbrigoActivity
import kotlin.String
import kotlin.Unit

class NovoEditarAnimalAbrigoActivity :
    BaseActivity<ActivityNovoEditarAnimalAbrigoBinding>(R.layout.activity_novo_editar_animal_abrigo) {
    private val viewModel: NovoEditarAnimalAbrigoVM by viewModels()

    override fun onInitialized(): Unit {
        viewModel.navArguments = intent.extras?.getBundle("bundle")
        binding.novoEditarAnimalAbrigoVM = viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnConfirm.setOnClickListener {

            if (binding.txtAnimalName.text.isEmpty()) {
                showToast("Informe o nome do animal.")
            }

            if (binding.txtAnimalSpecies.text.isEmpty()) {
                showToast("Informe a espécie do animal.")
            }

            if (binding.txtAnimalRace.text.isEmpty()) {
                showToast("Informe a raça do animal.")
            }

            if (binding.txtAnimalAge.text.isEmpty()) {
                showToast("Informe a idade do animal.")
            }

            if (binding.txtDetailsC.text.isEmpty() || binding.txtDetailsV.text.isEmpty()) {
                showToast("Informe detalhes de castração e vacina.")
            }

            if (!binding.rbPequeno.isChecked && !binding.rbMdio.isChecked && !binding.rbGrande.isChecked) {
                showToast("Informe o porte do animal.")
            }

            val porte = when {
                binding.rbPequeno.isChecked -> "pequeno"
                binding.rbMdio.isChecked -> "medio"
                else -> "grande"
            }

            viewModel.addAnimal(this,
                Animal(
                    name = binding.txtAnimalName.text.toString(),
                    species = binding.txtAnimalSpecies.text.toString(),
                    race = binding.txtAnimalRace.text.toString(),
                    age = binding.txtAnimalAge.text.toString(),
                    size = porte,
                    detailsc = binding.txtDetailsC.text.toString(),
                    detailsv = binding.txtDetailsV.text.toString(),
                    shelter = SharedPreferences.getLoggedId()
                )
            )

            startActivity(TelaPrincipalAbrigoActivity.getIntent(this, null))
        }
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

    companion object {
        const val TAG: String = "NOVO_EDITAR_ANIMAL_ABRIGO_ACTIVITY"

        fun getIntent(context: Context, bundle: Bundle?): Intent {
            val destIntent = Intent(context, NovoEditarAnimalAbrigoActivity::class.java)
            destIntent.putExtra("bundle", bundle)
            return destIntent
        }
    }
}
