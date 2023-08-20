package com.conectadot.app.modules.detalhescontato.data.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.conectadot.app.appcomponents.room.DatabaseUtils
import com.conectadot.app.appcomponents.room.Shelter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent

class DetalhesContatoViewModel: ViewModel(), KoinComponent {

    val shelter: MutableLiveData<Shelter> = MutableLiveData()

    fun getShelter(context: Context, id: Int) {
        CoroutineScope(Dispatchers.Default).launch {
            shelter.postValue(
                DatabaseUtils.getShelter(context, id)
            )
        }
    }
}