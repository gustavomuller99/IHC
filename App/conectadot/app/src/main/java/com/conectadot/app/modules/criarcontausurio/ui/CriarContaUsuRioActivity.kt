package com.conectadot.app.modules.criarcontausurio.ui

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.conectadot.app.R
import com.conectadot.app.appcomponents.base.BaseActivity
import com.conectadot.app.databinding.ActivityCriarContaUsuRioBinding
import com.conectadot.app.modules.criarcontausurio.`data`.viewmodel.CriarContaUsuRioVM
import com.conectadot.app.modules.telaprincipalusurio.ui.TelaPrincipalUsuRioActivity
import kotlin.String
import kotlin.Unit
import java.util.regex.*

class CriarContaUsuRioActivity :
    BaseActivity<ActivityCriarContaUsuRioBinding>(R.layout.activity_criar_conta_usu_rio) {
  private val viewModel: CriarContaUsuRioVM by viewModels<CriarContaUsuRioVM>()

  private val regex: String = "^(.+)@(.+)$"

  private val pattern : Pattern = Pattern.compile(regex)

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.criarContaUsuRioVM = viewModel
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    var matcher : Matcher

    binding.btnCadastrarOne.setOnClickListener(View.OnClickListener {
      // Validando se o texto de entrada do campo de email tem estrutura de email.
      matcher = pattern.matcher(binding.etUserEmail.text.toString())
      if(matcher.matches()){
        binding.etUserEmail.setTextColor(Color.BLACK)

        if(binding.etUserPassword.text.toString() == binding.etUserConfPassword.text.toString()){
          binding.etUserConfPassword.setTextColor(Color.BLACK)
          if(binding.etUserAddress.text.isNotEmpty() && binding.etUserState.text.isNotEmpty() && binding.etUserCity.text.isNotEmpty()){
            val intent = Intent(this, TelaPrincipalUsuRioActivity()::class.java)
            startActivity(intent)
          }
          else{
            Toast.makeText(this, "Informe dados de localização", Toast.LENGTH_SHORT).show()
          }
        }
        else{
          binding.etUserConfPassword.setTextColor(Color.RED)
          Toast.makeText(this, "Senhas não correspondem", Toast.LENGTH_SHORT).show()
        }
      }
      else{
        binding.etUserEmail.setTextColor(Color.RED)
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
    const val TAG: String = "CRIAR_CONTA_USU_RIO_ACTIVITY"

  }
}
