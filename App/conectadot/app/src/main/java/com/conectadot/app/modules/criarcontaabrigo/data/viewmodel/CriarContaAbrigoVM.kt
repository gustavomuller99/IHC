package com.conectadot.app.modules.criarcontaabrigo.`data`.viewmodel

import android.content.Context
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.conectadot.app.appcomponents.room.DatabaseUtils
import com.conectadot.app.appcomponents.room.Shelter
import com.conectadot.app.modules.criarcontaabrigo.`data`.model.CriarContaAbrigoModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent

class CriarContaAbrigoVM : ViewModel(), KoinComponent {
    val criarContaAbrigoModel: MutableLiveData<CriarContaAbrigoModel> =
        MutableLiveData(CriarContaAbrigoModel())
    var navArguments: Bundle? = null

    fun addShelter(context: Context, shelter: Shelter) {
        CoroutineScope(Dispatchers.Default).launch {
            DatabaseUtils.addShelter(context, shelter)
        }
    }
}
