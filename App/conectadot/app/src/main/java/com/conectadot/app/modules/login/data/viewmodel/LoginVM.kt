package com.conectadot.app.modules.login.`data`.viewmodel

import android.content.Context
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.conectadot.app.appcomponents.room.DatabaseUtils
import com.conectadot.app.modules.login.`data`.model.LoginModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent

class LoginVM : ViewModel(), KoinComponent {
    val loginModel: MutableLiveData<LoginModel> = MutableLiveData(LoginModel())
    var navArguments: Bundle? = null

    val loginUser: MutableLiveData<Boolean?> = MutableLiveData(null)
    val loginShelter: MutableLiveData<Boolean?> = MutableLiveData(null)

    fun loginUser(context: Context, email: String, password: String) {
        CoroutineScope(Dispatchers.Default).launch {
            if (DatabaseUtils.loginUser(context, email, password)) {
                loginUser.postValue(true)
            } else loginUser.postValue(false)
        }
    }

    fun loginShelter(context: Context, email: String, password: String) {
        CoroutineScope(Dispatchers.Default).launch {
            if (DatabaseUtils.loginShelter(context, email, password)) {
                loginShelter.postValue(true)
            } else loginShelter.postValue(false)
        }
    }
}
