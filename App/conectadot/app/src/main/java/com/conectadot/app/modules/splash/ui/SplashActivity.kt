package com.conectadot.app.modules.splash.ui

import android.content.Intent
import androidx.activity.viewModels
import com.conectadot.app.R
import com.conectadot.app.appcomponents.base.BaseActivity
import com.conectadot.app.databinding.ActivitySplashBinding
import com.conectadot.app.modules.login.ui.LoginActivity
import com.conectadot.app.modules.splash.data.viewmodel.SplashVM

class SplashActivity : BaseActivity<ActivitySplashBinding>(R.layout.activity_splash) {

    private val viewModel: SplashVM by viewModels()

    override fun onInitialized() {
        viewModel.navArguments = intent.extras?.getBundle("bundle")
        binding.splashVM = viewModel
    }

    override fun setUpClicks() {
        binding.linearRowcomeeagora.setOnClickListener {
            val intent = Intent(this, LoginActivity()::class.java)
            startActivity(intent)
        }
    }

    companion object {
        const val TAG: String = "SPLASH_ACTIVITY"
    }
}
