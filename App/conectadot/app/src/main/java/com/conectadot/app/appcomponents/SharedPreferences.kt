package com.conectadot.app.appcomponents

import android.app.Activity
import android.content.Context
import com.conectadot.app.modules.login.data.viewmodel.LoginResult

object SharedPreferences {

    private const val sLoggedId = "LOGGED_ID"
    private const val sLoggedType = "LOGGED_ID_TYPE"
    lateinit var preferences: android.content.SharedPreferences

    fun initPreferences(activity: Activity) {
        preferences = activity.getPreferences(Context.MODE_PRIVATE)
    }

    fun setLoggedId(id: Int) {
        val sharedPref = preferences
        with (sharedPref.edit()) {
            putInt(sLoggedId, id)
            commit()
        }
    }

    fun getLoggedId(): Int {
        return preferences
            .getInt(sLoggedId, -1)
    }

    fun setLoggedType(loggedType: LoggedType) {
        val sharedPref = preferences
        with (sharedPref.edit()) {
            putInt(sLoggedType, loggedType.value)
            commit()
        }
    }

    fun getLoggedType(): LoggedType? {
        return LoggedType.fromInt(preferences
            .getInt(sLoggedType, -1))
    }

    fun isLogged(): Boolean {
        return getLoggedId() != LoginResult.Failed.value
    }
}

enum class LoggedType(val value: Int) {
    User(0),
    Shelter(1);

    companion object {
        fun fromInt(value: Int): LoggedType? {
            return enumValues<LoggedType>().firstOrNull() { it.value == value }
        }
    }
}