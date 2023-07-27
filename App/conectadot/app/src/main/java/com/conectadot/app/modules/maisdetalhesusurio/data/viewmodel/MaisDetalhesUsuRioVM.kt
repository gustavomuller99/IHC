package com.conectadot.app.modules.maisdetalhesusurio.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.conectadot.app.modules.maisdetalhesusurio.`data`.model.MaisDetalhesUsuRioModel
import org.koin.core.KoinComponent

class MaisDetalhesUsuRioVM : ViewModel(), KoinComponent {
  val maisDetalhesUsuRioModel: MutableLiveData<MaisDetalhesUsuRioModel> =
      MutableLiveData(MaisDetalhesUsuRioModel())

  var navArguments: Bundle? = null
}
