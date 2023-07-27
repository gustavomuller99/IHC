package com.conectadot.app.modules.criarcontausurio.ui

import androidx.activity.viewModels
import com.conectadot.app.R
import com.conectadot.app.appcomponents.base.BaseActivity
import com.conectadot.app.databinding.ActivityCriarContaUsuRioBinding
import com.conectadot.app.modules.criarcontausurio.`data`.viewmodel.CriarContaUsuRioVM
import kotlin.String
import kotlin.Unit

class CriarContaUsuRioActivity :
    BaseActivity<ActivityCriarContaUsuRioBinding>(R.layout.activity_criar_conta_usu_rio) {
  private val viewModel: CriarContaUsuRioVM by viewModels<CriarContaUsuRioVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.criarContaUsuRioVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "CRIAR_CONTA_USU_RIO_ACTIVITY"

  }
}
