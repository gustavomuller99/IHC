package com.conectadot.app.modules.telaprincipalusurio.`data`.viewmodel

import android.content.Context
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.conectadot.app.appcomponents.room.Animal
import com.conectadot.app.appcomponents.room.DatabaseUtils
import com.conectadot.app.appcomponents.room.Shelter
import com.conectadot.app.modules.telaprincipalusurio.`data`.model.TelaPrincipalUsuRioModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent

class TelaPrincipalUsuRioVM : ViewModel(), KoinComponent {

    private var animalList: MutableList<Animal> = mutableListOf()
    private var currentPos = 0
    val currentAnimal: MutableLiveData<Animal?> = MutableLiveData()
    val currentAnimalShelter: MutableLiveData<Shelter?> = MutableLiveData()
    var navArguments: Bundle? = null

    fun getAnimalList(context: Context) {
        CoroutineScope(Dispatchers.Default).launch {
            animalList = DatabaseUtils.getAllAnimals(context).toMutableList()
            currentAnimal.postValue(
                animalList.getOrNull(currentPos).also {
                    getAnimalShelter(context, it?.shelter)
                }
            )
        }
    }

    fun getNextAnimal(context: Context) {
        currentPos += 1
        currentAnimal.postValue(
            animalList.getOrNull(currentPos).also {
                getAnimalShelter(context, it?.shelter)
            }
        )
    }

    private fun getAnimalShelter(context: Context, id: Int?) {
        CoroutineScope(Dispatchers.Default).launch {
            currentAnimalShelter.postValue(
                DatabaseUtils.getShelter(context, id)
            )
        }
    }
}
