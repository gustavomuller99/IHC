package com.conectadot.app.modules.chatabrigousurio.`data`.viewmodel

import android.content.Context
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.conectadot.app.appcomponents.room.DatabaseUtils
import com.conectadot.app.appcomponents.room.Message
import com.conectadot.app.modules.chatabrigousurio.`data`.model.ChatAbrigoUsuRioModel
import org.koin.core.KoinComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ChatAbrigoUsuRioVM : ViewModel(), KoinComponent {
  val chatAbrigoUsuRioModel: MutableLiveData<ChatAbrigoUsuRioModel> =
      MutableLiveData(ChatAbrigoUsuRioModel())

  var navArguments: Bundle? = null

    fun addMessage(context: Context, message: Message) {
        CoroutineScope(Dispatchers.Default).launch {
            DatabaseUtils.addMessage(context, message)
        }
    }
}
