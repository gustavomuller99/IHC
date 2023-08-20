package com.conectadot.app.modules.maisdetalhesusurio.`data`.viewmodel

import android.content.Context
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.conectadot.app.appcomponents.room.Animal
import com.conectadot.app.appcomponents.room.DatabaseUtils
import com.conectadot.app.modules.maisdetalhesusurio.`data`.model.MaisDetalhesUsuRioModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent

class MaisDetalhesUsuRioVM : ViewModel(), KoinComponent {
  val maisDetalhesUsuRioModel: MutableLiveData<MaisDetalhesUsuRioModel> =
      MutableLiveData(MaisDetalhesUsuRioModel())

  var navArguments: Bundle? = null

    val animal: MutableLiveData<Animal> = MutableLiveData()

    fun getAnimal(context: Context, animal_id: Int) {
        CoroutineScope(Dispatchers.Default).launch {
            DatabaseUtils.getAnimalDetails(context, animal_id)?.let{
                animal.postValue(it)
            }
        }
    }
}
