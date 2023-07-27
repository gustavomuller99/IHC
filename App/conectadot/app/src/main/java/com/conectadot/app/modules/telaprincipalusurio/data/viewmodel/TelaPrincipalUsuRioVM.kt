package com.conectadot.app.modules.telaprincipalusurio.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.conectadot.app.modules.telaprincipalusurio.`data`.model.TelaPrincipalUsuRioModel
import org.koin.core.KoinComponent

class TelaPrincipalUsuRioVM : ViewModel(), KoinComponent {
  val telaPrincipalUsuRioModel: MutableLiveData<TelaPrincipalUsuRioModel> =
      MutableLiveData(TelaPrincipalUsuRioModel())

  var navArguments: Bundle? = null
}
