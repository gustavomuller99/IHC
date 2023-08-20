package com.conectadot.app.modules.criarcontaabrigo.ui

import android.graphics.Color
import android.widget.Toast
import androidx.activity.viewModels
import com.conectadot.app.R
import com.conectadot.app.appcomponents.base.BaseActivity
import com.conectadot.app.appcomponents.room.Shelter
import com.conectadot.app.databinding.ActivityCriarContaAbrigoBinding
import com.conectadot.app.modules.criarcontaabrigo.data.viewmodel.CriarContaAbrigoVM
import com.conectadot.app.modules.login.ui.LoginActivity
import java.util.regex.Matcher
import java.util.regex.Pattern

class CriarContaAbrigoActivity :
    BaseActivity<ActivityCriarContaAbrigoBinding>(R.layout.activity_criar_conta_abrigo) {
    private val viewModel: CriarContaAbrigoVM by viewModels()

    private val regex: String = "^(.+)@(.+)$"

    private val pattern: Pattern = Pattern.compile(regex)

    override fun onInitialized() {
        viewModel.navArguments = intent.extras?.getBundle("bundle")
        binding.criarContaAbrigoVM = viewModel

        var matcher: Matcher

        binding.btnCadastrar.setOnClickListener {
            // Validando se o texto de entrada do campo de email tem estrutura de email.
            matcher = pattern.matcher(binding.etShelterEmail.text.toString())
            if (matcher.matches()) {
                binding.etShelterEmail.setTextColor(Color.BLACK)

                if (binding.etShelterPassword.text.toString() == binding.etShelterConfPassword.text.toString()) {
                    binding.etShelterConfPassword.setTextColor(Color.BLACK)
                    if (binding.etShelterName.text.isNotEmpty() && binding.etShelterAddress.text.isNotEmpty() && binding.etShelterState.text.isNotEmpty() && binding.etShelterCity.text.isNotEmpty()) {

                        viewModel.addShelter(
                            this,
                            Shelter(
                                name = binding.etShelterName.text.toString(),
                                email = binding.etShelterEmail.text.toString(),
                                password = binding.etShelterPassword.text.toString(),
                                address = binding.etShelterAddress.text.toString(),
                                state = binding.etShelterState.text.toString(),
                                city = binding.etShelterCity.text.toString(),
                            )
                        )

                        finish()
                    } else {
                        Toast.makeText(
                            this,
                            "Informe nome e dados de localização",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    binding.etShelterConfPassword.setTextColor(Color.RED)
                    Toast.makeText(this, "Senhas não correspondem", Toast.LENGTH_SHORT).show()
                }
            } else {
                binding.etShelterEmail.setTextColor(Color.RED)
                Toast.makeText(this, "Favor inserir um email válido", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun setUpClicks() {
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
