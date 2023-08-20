package com.conectadot.app.modules.novoeditaranimalabrigo.`data`.viewmodel

import android.content.Context
import android.os.Bundle
import android.provider.ContactsContract.Data
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

    val currentAnimal: MutableLiveData<Animal?> = MutableLiveData()

    fun addAnimal(context: Context, animal: Animal) {
        CoroutineScope(Dispatchers.Default).launch {
            DatabaseUtils.addAnimal(context, animal)
        }
    }

    fun updateAnimal(context: Context, animal: Animal, animalID: Int){
        CoroutineScope(Dispatchers.Default).launch{
            DatabaseUtils.updateAnimal(context, animal, animalID)
        }
    }

    fun getAnimal(context: Context, id: Int) {
        CoroutineScope(Dispatchers.Default).launch {
            currentAnimal.postValue(DatabaseUtils.getAnimalDetails(context, id))
        }
    }
}
