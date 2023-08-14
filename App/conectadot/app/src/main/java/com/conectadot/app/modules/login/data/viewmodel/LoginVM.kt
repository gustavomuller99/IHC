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

    val loginUser: MutableLiveData<Int> = MutableLiveData(LoginResult.NotTried.value)
    val loginShelter: MutableLiveData<Int> = MutableLiveData(LoginResult.NotTried.value)

    fun loginUser(context: Context, email: String, password: String) {
        CoroutineScope(Dispatchers.Default).launch {
            DatabaseUtils.loginUser(context, email, password).let {
                loginUser.postValue(it)
            }
        }
    }

    fun loginShelter(context: Context, email: String, password: String) {
        CoroutineScope(Dispatchers.Default).launch {
            DatabaseUtils.loginShelter(context, email, password).let {
                loginShelter.postValue(it)
            }
        }
    }
}

enum class LoginResult(val value: Int) {
    Failed(-1),
    NotTried(-2);
}
