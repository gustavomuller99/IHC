package com.conectadot.app.modules.splash.ui

import android.content.Intent
import androidx.activity.viewModels
import com.conectadot.app.R
import com.conectadot.app.appcomponents.LoggedType
import com.conectadot.app.appcomponents.SharedPreferences
import com.conectadot.app.appcomponents.base.BaseActivity
import com.conectadot.app.databinding.ActivitySplashBinding
import com.conectadot.app.modules.login.ui.LoginActivity
import com.conectadot.app.modules.splash.data.viewmodel.SplashVM
import com.conectadot.app.modules.telaprincipalabrigo.ui.TelaPrincipalAbrigoActivity
import com.conectadot.app.modules.telaprincipalusurio.ui.TelaPrincipalUsuRioActivity

class SplashActivity : BaseActivity<ActivitySplashBinding>(R.layout.activity_splash) {

    private val viewModel: SplashVM by viewModels()

    override fun onInitialized() {
        SharedPreferences.initPreferences(this)
        checkLogged()
        viewModel.navArguments = intent.extras?.getBundle("bundle")
        binding.splashVM = viewModel
    }

    override fun setUpClicks() {
        binding.linearRowcomeeagora.setOnClickListener {
            val intent = Intent(this, LoginActivity()::class.java)
            startActivity(intent)
        }
    }

    private fun checkLogged() {
        if (SharedPreferences.isLogged()) {
            when(SharedPreferences.getLoggedType()) {
                LoggedType.User -> startActivity(TelaPrincipalUsuRioActivity.getIntent(this, null))
                else -> startActivity(TelaPrincipalAbrigoActivity.getIntent(this, null))
            }
        }
    }

    companion object {
        const val TAG: String = "SPLASH_ACTIVITY"
    }
}
