package com.conectadot.app.modules.novoeditaranimalabrigo.`data`.viewmodel

import android.content.Context
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.conectadot.app.appcomponents.room.Animal
import com.conectadot.app.appcomponents.room.DatabaseUtils
import com.conectadot.app.modules.novoeditaranimalabrigo.`data`.model.NovoEditarAnimalAbrigoModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent

class NovoEditarAnimalAbrigoVM : ViewModel(), KoinComponent {
  val novoEditarAnimalAbrigoModel: MutableLiveData<NovoEditarAnimalAbrigoModel> =
      MutableLiveData(NovoEditarAnimalAbrigoModel())

  var navArguments: Bundle? = null

    fun addAnimal(context: Context, animal: Animal) {
        CoroutineScope(Dispatchers.Default).launch {
            DatabaseUtils.addAnimal(context, animal)
        }
    }
}
