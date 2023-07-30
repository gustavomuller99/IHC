package com.conectadot.app.modules.login.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.conectadot.app.R
import com.conectadot.app.appcomponents.base.BaseActivity
import com.conectadot.app.appcomponents.facebookauth.FacebookHelper
import com.conectadot.app.databinding.ActivityLoginBinding
import com.conectadot.app.modules.criarcontaabrigo.ui.CriarContaAbrigoActivity
import com.conectadot.app.modules.criarcontausurio.ui.CriarContaUsuRioActivity
import com.conectadot.app.modules.login.`data`.viewmodel.LoginVM
import com.conectadot.app.modules.splash.ui.SplashActivity
import com.conectadot.app.modules.telaprincipalabrigo.ui.TelaPrincipalAbrigoActivity
import com.conectadot.app.modules.telaprincipalusurio.ui.TelaPrincipalUsuRioActivity
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import kotlin.Int
import kotlin.String
import kotlin.Unit

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {
  private val viewModel: LoginVM by viewModels<LoginVM>()

  private var callbackManager: CallbackManager = CallbackManager.Factory.create()

  private val facebookLogin: FacebookHelper = FacebookHelper()

  override fun onActivityResult(
    requestCode: Int,
    resultCode: Int,
    `data`: Intent?
  ): Unit {
    callbackManager.onActivityResult(requestCode, resultCode, data)
    super.onActivityResult(requestCode,resultCode,data)
  }

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.loginVM = viewModel
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding.btnEntrarOne.setOnClickListener(View.OnClickListener {
      if(binding.etEmail.text.toString() == "user@domain.com" && binding.etPassword.text.toString() == "1234"){
        val intent = Intent(this, TelaPrincipalUsuRioActivity()::class.java)
        startActivity(intent)
        }
      else if(binding.etEmail.text.toString() == "shelter@domain.com" && binding.etPassword.text.toString() == "1234"){
        val intent = Intent(this, TelaPrincipalAbrigoActivity()::class.java)
        startActivity(intent)
      }
      else{
        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
      }
    })
  }
  override fun setUpClicks(): Unit {
    binding.txtNopossuicont.setOnClickListener {
      val intent = Intent(this, CriarContaUsuRioActivity()::class.java)
      startActivity(intent)
      overridePendingTransition(R.anim.anim_pull_right, R.anim.anim_push_left)
    }

    binding.txtAbrigodeanima.setOnClickListener {
      val intent = Intent(this, CriarContaAbrigoActivity()::class.java)
      startActivity(intent)
      overridePendingTransition(R.anim.anim_pull_right, R.anim.anim_push_left)
    }
  }

    companion object {
      const val TAG: String = "LOGIN_ACTIVITY"

      fun getIntent(context: Context, bundle: Bundle?): Intent {
        val destIntent = Intent(context, LoginActivity::class.java)
        destIntent.putExtra("bundle", bundle)
        return destIntent
      }
    }
  }
