package com.conectadot.app.modules.chatabrigousurio.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.conectadot.app.modules.chatabrigousurio.`data`.model.ChatAbrigoUsuRioModel
import org.koin.core.KoinComponent

class ChatAbrigoUsuRioVM : ViewModel(), KoinComponent {
  val chatAbrigoUsuRioModel: MutableLiveData<ChatAbrigoUsuRioModel> =
      MutableLiveData(ChatAbrigoUsuRioModel())

  var navArguments: Bundle? = null
}
