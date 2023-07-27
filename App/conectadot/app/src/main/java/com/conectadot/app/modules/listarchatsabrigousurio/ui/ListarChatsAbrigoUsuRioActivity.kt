package com.conectadot.app.modules.listarchatsabrigousurio.ui

import androidx.activity.viewModels
import com.conectadot.app.R
import com.conectadot.app.appcomponents.base.BaseActivity
import com.conectadot.app.databinding.ActivityListarChatsAbrigoUsuRioBinding
import com.conectadot.app.modules.listarchatsabrigousurio.`data`.viewmodel.ListarChatsAbrigoUsuRioVM
import kotlin.String
import kotlin.Unit

class ListarChatsAbrigoUsuRioActivity :
    BaseActivity<ActivityListarChatsAbrigoUsuRioBinding>(R.layout.activity_listar_chats_abrigo_usu_rio)
    {
  private val viewModel: ListarChatsAbrigoUsuRioVM by viewModels<ListarChatsAbrigoUsuRioVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.listarChatsAbrigoUsuRioVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "LISTAR_CHATS_ABRIGO_USU_RIO_ACTIVITY"

  }
}
