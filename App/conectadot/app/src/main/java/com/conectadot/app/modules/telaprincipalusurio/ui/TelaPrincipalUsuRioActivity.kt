package com.conectadot.app.modules.telaprincipalusurio.ui

import androidx.activity.viewModels
import com.conectadot.app.R
import com.conectadot.app.appcomponents.base.BaseActivity
import com.conectadot.app.databinding.ActivityTelaPrincipalUsuRioBinding
import com.conectadot.app.modules.chatabrigousurio.ui.ChatAbrigoUsuRioActivity
import com.conectadot.app.modules.maisdetalhesusurio.ui.MaisDetalhesUsuRioBottomsheet
import com.conectadot.app.modules.telaprincipalusurio.`data`.viewmodel.TelaPrincipalUsuRioVM
import kotlin.String
import kotlin.Unit

class TelaPrincipalUsuRioActivity :
    BaseActivity<ActivityTelaPrincipalUsuRioBinding>(R.layout.activity_tela_principal_usu_rio) {
  private val viewModel: TelaPrincipalUsuRioVM by viewModels<TelaPrincipalUsuRioVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.telaPrincipalUsuRioVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowup.setOnClickListener {
      val sheet = MaisDetalhesUsuRioBottomsheet()
      sheet.show(supportFragmentManager, "")
    }

    binding.linearColumnforward.setOnClickListener {
      startActivity(ChatAbrigoUsuRioActivity.getIntent(this, null))
    }

    binding.btnForward.setOnClickListener {
      startActivity(ChatAbrigoUsuRioActivity.getIntent(this, null))
    }
  }

  companion object {
    const val TAG: String = "TELA_PRINCIPAL_USU_RIO_ACTIVITY"

  }
}
