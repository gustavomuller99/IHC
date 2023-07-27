package com.conectadot.app.modules.telaprincipalabrigo.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.conectadot.app.modules.telaprincipalabrigo.`data`.model.ListrectangleeightRowModel
import com.conectadot.app.modules.telaprincipalabrigo.`data`.model.TelaPrincipalAbrigoModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class TelaPrincipalAbrigoVM : ViewModel(), KoinComponent {
  val telaPrincipalAbrigoModel: MutableLiveData<TelaPrincipalAbrigoModel> =
      MutableLiveData(TelaPrincipalAbrigoModel())

  var navArguments: Bundle? = null

  val listrectangleeightList: MutableLiveData<MutableList<ListrectangleeightRowModel>> =
      MutableLiveData(mutableListOf())
}
