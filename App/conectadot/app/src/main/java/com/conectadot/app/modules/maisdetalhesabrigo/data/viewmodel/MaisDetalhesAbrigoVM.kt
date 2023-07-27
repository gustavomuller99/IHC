package com.conectadot.app.modules.maisdetalhesabrigo.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.conectadot.app.modules.maisdetalhesabrigo.`data`.model.MaisDetalhesAbrigoModel
import org.koin.core.KoinComponent

class MaisDetalhesAbrigoVM : ViewModel(), KoinComponent {
  val maisDetalhesAbrigoModel: MutableLiveData<MaisDetalhesAbrigoModel> =
      MutableLiveData(MaisDetalhesAbrigoModel())

  var navArguments: Bundle? = null
}
