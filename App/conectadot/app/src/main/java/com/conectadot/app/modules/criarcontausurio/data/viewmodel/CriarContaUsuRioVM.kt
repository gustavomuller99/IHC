package com.conectadot.app.modules.criarcontausurio.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.conectadot.app.modules.criarcontausurio.`data`.model.CriarContaUsuRioModel
import org.koin.core.KoinComponent

class CriarContaUsuRioVM : ViewModel(), KoinComponent {
  val criarContaUsuRioModel: MutableLiveData<CriarContaUsuRioModel> =
      MutableLiveData(CriarContaUsuRioModel())

  var navArguments: Bundle? = null
}
