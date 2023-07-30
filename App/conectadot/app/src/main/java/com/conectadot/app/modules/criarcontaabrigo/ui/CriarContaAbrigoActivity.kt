package com.conectadot.app.modules.criarcontaabrigo.ui

import android.content.Intent
import android.graphics.Color
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.conectadot.app.R
import com.conectadot.app.appcomponents.base.BaseActivity
import com.conectadot.app.databinding.ActivityCriarContaAbrigoBinding
import com.conectadot.app.modules.criarcontaabrigo.`data`.viewmodel.CriarContaAbrigoVM
import com.conectadot.app.modules.telaprincipalabrigo.ui.TelaPrincipalAbrigoActivity
import com.conectadot.app.modules.telaprincipalusurio.ui.TelaPrincipalUsuRioActivity
import java.util.regex.Matcher
import java.util.regex.Pattern
import kotlin.String
import kotlin.Unit

class CriarContaAbrigoActivity :
    BaseActivity<ActivityCriarContaAbrigoBinding>(R.layout.activity_criar_conta_abrigo) {
  private val viewModel: CriarContaAbrigoVM by viewModels<CriarContaAbrigoVM>()

  private val regex: String = "^(.+)@(.+)$"

  private val pattern : Pattern = Pattern.compile(regex)

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.criarContaAbrigoVM = viewModel

    var matcher : Matcher

    binding.btnCadastrar.setOnClickListener(View.OnClickListener {
      // Validando se o texto de entrada do campo de email tem estrutura de email.
      matcher = pattern.matcher(binding.etShelterEmail.text.toString())
      if(matcher.matches()){
        binding.etShelterEmail.setTextColor(Color.BLACK)

        if(binding.etShelterPassword.text.toString() == binding.etShelterConfPassword.text.toString()){
          binding.etShelterConfPassword.setTextColor(Color.BLACK)
          if(binding.etShelterName.text.isNotEmpty() && binding.etShelterAddress.text.isNotEmpty() && binding.etShelterState.text.isNotEmpty() && binding.etShelterCity.text.isNotEmpty()){
            val intent = Intent(this, TelaPrincipalAbrigoActivity()::class.java)
            startActivity(intent)
          }
          else{
            Toast.makeText(this, "Informe nome e dados de localização", Toast.LENGTH_SHORT).show()
          }
        }
        else{
          binding.etShelterConfPassword.setTextColor(Color.RED)
          Toast.makeText(this, "Senhas não correspondem", Toast.LENGTH_SHORT).show()
        }
      }
      else{
        binding.etShelterEmail.setTextColor(Color.RED)
        Toast.makeText(this, "Favor inserir um email válido", Toast.LENGTH_SHORT).show()
      }
    })
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
      overridePendingTransition(R.anim.anim_pull_left, R.anim.anim_push_right)
    }
  }

  override fun onBackPressed() {
    overridePendingTransition(R.anim.anim_pull_left, R.anim.anim_push_right)
  }

  companion object {
    const val TAG: String = "CRIAR_CONTA_ABRIGO_ACTIVITY"

  }
}
