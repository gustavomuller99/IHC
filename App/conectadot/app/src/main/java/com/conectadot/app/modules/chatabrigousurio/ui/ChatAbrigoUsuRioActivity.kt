package com.conectadot.app.modules.chatabrigousurio.ui

import androidx.activity.viewModels
import com.conectadot.app.R
import com.conectadot.app.appcomponents.base.BaseActivity
import com.conectadot.app.databinding.ActivityChatAbrigoUsuRioBinding
import com.conectadot.app.modules.chatabrigousurio.`data`.viewmodel.ChatAbrigoUsuRioVM
import kotlin.String
import kotlin.Unit

class ChatAbrigoUsuRioActivity :
    BaseActivity<ActivityChatAbrigoUsuRioBinding>(R.layout.activity_chat_abrigo_usu_rio) {
  private val viewModel: ChatAbrigoUsuRioVM by viewModels<ChatAbrigoUsuRioVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.chatAbrigoUsuRioVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "CHAT_ABRIGO_USU_RIO_ACTIVITY"

  }
}