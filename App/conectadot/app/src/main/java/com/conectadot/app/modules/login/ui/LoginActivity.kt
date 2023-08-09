package com.conectadot.app.modules.login.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.conectadot.app.R
import com.conectadot.app.appcomponents.base.BaseActivity
import com.conectadot.app.databinding.ActivityLoginBinding
import com.conectadot.app.modules.criarcontaabrigo.ui.CriarContaAbrigoActivity
import com.conectadot.app.modules.criarcontausurio.ui.CriarContaUsuRioActivity
import com.conectadot.app.modules.login.`data`.viewmodel.LoginVM
import com.conectadot.app.modules.telaprincipalabrigo.ui.TelaPrincipalAbrigoActivity
import com.conectadot.app.modules.telaprincipalusurio.ui.TelaPrincipalUsuRioActivity
import com.facebook.CallbackManager
import kotlin.Int
import kotlin.String

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {
    private val viewModel: LoginVM by viewModels()

    private var callbackManager: CallbackManager = CallbackManager.Factory.create()

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        `data`: Intent?
    ) {
        callbackManager.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onInitialized() {
        viewModel.navArguments = intent.extras?.getBundle("bundle")
        binding.loginVM = viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnEntrarOne.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            viewModel.loginUser(this, email, password)
        }

        viewModel.loginUser.observe(this) {
            if (it == true) {
                startActivity(TelaPrincipalUsuRioActivity.getIntent(this, null))
            } else if (it == false) {
                val email = binding.etEmail.text.toString()
                val password = binding.etPassword.text.toString()
                viewModel.loginShelter(this, email, password)
            }
        }

        viewModel.loginShelter.observe(this) {
            if (it == true) {
                startActivity(TelaPrincipalAbrigoActivity.getIntent(this, null))
            } else if (it == false) {
                Toast.makeText(this, "Email ou senha incorretos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun setUpClicks() {
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
