package com.conectadot.app.modules.telaprincipalusurio.ui

import android.content.Context
import android.content.Intent
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import com.conectadot.app.R
import com.conectadot.app.appcomponents.SharedPreferences
import com.conectadot.app.appcomponents.base.BaseActivity
import com.conectadot.app.databinding.ActivityTelaPrincipalUsuRioBinding
import com.conectadot.app.modules.detalhescontato.ui.DetalhesContatoActivity
import com.conectadot.app.modules.login.data.viewmodel.LoginResult
import com.conectadot.app.modules.maisdetalhesusurio.ui.MaisDetalhesUsuRioBottomsheet
import com.conectadot.app.modules.telaprincipalusurio.`data`.viewmodel.TelaPrincipalUsuRioVM
import kotlin.String

class TelaPrincipalUsuRioActivity :
    BaseActivity<ActivityTelaPrincipalUsuRioBinding>(R.layout.activity_tela_principal_usu_rio) {
    private val viewModel: TelaPrincipalUsuRioVM by viewModels()

    override fun onInitialized() {
        viewModel.navArguments = intent.extras?.getBundle("bundle")
        viewModel.getAnimalList(this)
    }

    override fun setUpClicks() {
        viewModel.currentAnimalShelter.observe(this) {
            it?.let {
                binding.txtLanguage.text = "${getString(R.string.lbl_nome)} ${viewModel.currentAnimal.value?.name}"
                binding.txtAbrigoLaador.text = "${getString(R.string.lbl_abrigo)} ${it.name}"

                viewModel.currentAnimal.value?.image?.let {
                    Uri.parse(it)?.let { uri ->
                        val bitmap = ImageDecoder.decodeBitmap(
                            ImageDecoder.createSource(
                                contentResolver,
                                uri
                            )
                        )
                        binding.imageRectangleEight.setImageBitmap(bitmap)
                    }
                } ?: binding.imageRectangleEight.setImageDrawable(
                    getDrawable(
                        R.drawable.dog
                    )
                )
            } ?: setNullValues()
        }

        binding.imageArrowup.setOnClickListener {
            val sheet = MaisDetalhesUsuRioBottomsheet()
            sheet.show(supportFragmentManager, "")
        }

        binding.btnForward.setOnClickListener {
            viewModel.currentAnimalShelter.value?.uid?.let {
                val sheet = DetalhesContatoActivity()
                val bundle = Bundle()
                bundle.putInt("id", it)
                sheet.arguments = bundle
                sheet.show(supportFragmentManager, null)
            }
        }

        binding.btnClose.setOnClickListener {
            viewModel.getNextAnimal(this)
        }
    }

    private fun setNullValues() {
        binding.txtLanguage.text = "Não há mais animais disponíveis!"
        binding.txtAbrigoLaador.text = ""
        binding.imageRectangleEight.setImageDrawable(null)
    }

    override fun onBackPressed() {
        SharedPreferences.setLoggedId(LoginResult.Failed.value)
        super.onBackPressed()
    }

    companion object {
        const val TAG: String = "TELA_PRINCIPAL_USU_RIO_ACTIVITY"

        fun getIntent(context: Context, bundle: Bundle?): Intent {
            val destIntent = Intent(context, TelaPrincipalUsuRioActivity::class.java)
            destIntent.putExtra("bundle", bundle)
            return destIntent
        }
    }
}
