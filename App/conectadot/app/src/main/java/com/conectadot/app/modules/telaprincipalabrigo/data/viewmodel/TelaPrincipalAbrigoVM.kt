package com.conectadot.app.modules.telaprincipalabrigo.`data`.viewmodel

import android.content.Context
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.conectadot.app.R
import com.conectadot.app.appcomponents.SharedPreferences
import com.conectadot.app.appcomponents.di.MyApp
import com.conectadot.app.appcomponents.room.DatabaseUtils
import com.conectadot.app.modules.telaprincipalabrigo.`data`.model.ListrectangleeightRowModel
import com.conectadot.app.modules.telaprincipalabrigo.`data`.model.TelaPrincipalAbrigoModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class TelaPrincipalAbrigoVM : ViewModel(), KoinComponent {

    val telaPrincipalAbrigoModel: MutableLiveData<TelaPrincipalAbrigoModel> = MutableLiveData(TelaPrincipalAbrigoModel())
    var navArguments: Bundle? = null
    val listrectangleeightList: MutableLiveData<MutableList<ListrectangleeightRowModel>> = MutableLiveData(mutableListOf())

    fun updateAnimalList(context: Context) {
        CoroutineScope(Dispatchers.Default).launch {
            listrectangleeightList.postValue(
                DatabaseUtils.getAnimalList(context, SharedPreferences.getLoggedId()).map {
                    ListrectangleeightRowModel(
                        txtNome = (MyApp.getInstance().resources.getString(R.string.lbl_nome) + " " + it.name),
                        txtRace = (MyApp.getInstance().resources.getString(R.string.lbl_race) + " " + it.race),
                        txtPorte = (MyApp.getInstance().resources.getString(R.string.lbl_porte) + " " + it.size)
                    )
                }.toMutableList()
            )
        }
    }

}
