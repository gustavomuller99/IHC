package com.conectadot.app.modules.novoeditaranimalabrigo.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.conectadot.app.modules.novoeditaranimalabrigo.`data`.model.NovoEditarAnimalAbrigoModel
import org.koin.core.KoinComponent

class NovoEditarAnimalAbrigoVM : ViewModel(), KoinComponent {
  val novoEditarAnimalAbrigoModel: MutableLiveData<NovoEditarAnimalAbrigoModel> =
      MutableLiveData(NovoEditarAnimalAbrigoModel())

  var navArguments: Bundle? = null
}
