package com.conectadot.app.modules.criarcontausurio.`data`.viewmodel

import android.content.Context
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.conectadot.app.appcomponents.room.DatabaseUtils
import com.conectadot.app.appcomponents.room.User
import com.conectadot.app.modules.criarcontausurio.`data`.model.CriarContaUsuRioModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent

class CriarContaUsuRioVM : ViewModel(), KoinComponent {
    val criarContaUsuRioModel: MutableLiveData<CriarContaUsuRioModel> =
        MutableLiveData(CriarContaUsuRioModel())

    var navArguments: Bundle? = null

    fun addUser(context: Context, user: User) {
        CoroutineScope(Dispatchers.Default).launch {
            DatabaseUtils.addUser(context, user)
        }
    }
}
