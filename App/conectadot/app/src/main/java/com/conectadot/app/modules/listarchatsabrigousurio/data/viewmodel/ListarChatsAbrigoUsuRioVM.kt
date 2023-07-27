package com.conectadot.app.modules.listarchatsabrigousurio.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.conectadot.app.modules.listarchatsabrigousurio.`data`.model.ListarChatsAbrigoUsuRioModel
import org.koin.core.KoinComponent

class ListarChatsAbrigoUsuRioVM : ViewModel(), KoinComponent {
  val listarChatsAbrigoUsuRioModel: MutableLiveData<ListarChatsAbrigoUsuRioModel> =
      MutableLiveData(ListarChatsAbrigoUsuRioModel())

  var navArguments: Bundle? = null
}
