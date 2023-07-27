package com.conectadot.app.modules.criarcontaabrigo.ui

import androidx.activity.viewModels
import com.conectadot.app.R
import com.conectadot.app.appcomponents.base.BaseActivity
import com.conectadot.app.databinding.ActivityCriarContaAbrigoBinding
import com.conectadot.app.modules.criarcontaabrigo.`data`.viewmodel.CriarContaAbrigoVM
import kotlin.String
import kotlin.Unit

class CriarContaAbrigoActivity :
    BaseActivity<ActivityCriarContaAbrigoBinding>(R.layout.activity_criar_conta_abrigo) {
  private val viewModel: CriarContaAbrigoVM by viewModels<CriarContaAbrigoVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.criarContaAbrigoVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "CRIAR_CONTA_ABRIGO_ACTIVITY"

  }
}
