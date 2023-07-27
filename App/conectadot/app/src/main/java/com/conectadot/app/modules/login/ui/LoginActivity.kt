package com.conectadot.app.modules.login.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.conectadot.app.R
import com.conectadot.app.appcomponents.base.BaseActivity
import com.conectadot.app.appcomponents.facebookauth.FacebookHelper
import com.conectadot.app.databinding.ActivityLoginBinding
import com.conectadot.app.modules.login.`data`.viewmodel.LoginVM
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

  override fun setUpClicks(): Unit {
    binding.btnFacebook.setOnClickListener {
      LoginManager.getInstance().logInWithReadPermissions(this, listOf("public_profile"))
      facebookLogin.login(callbackManager,object : FacebookCallback<LoginResult> {
        override fun onSuccess(result: LoginResult?) {
        }
        override fun onError(error: FacebookException?) {
        }
        override fun onCancel() {
        }
        })
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
