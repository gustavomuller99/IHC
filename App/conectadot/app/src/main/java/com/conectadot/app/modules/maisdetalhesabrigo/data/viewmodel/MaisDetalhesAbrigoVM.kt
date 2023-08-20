package com.conectadot.app.modules.maisdetalhesabrigo.`data`.viewmodel

import android.content.Context
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.conectadot.app.R
import com.conectadot.app.appcomponents.room.DatabaseUtils
import com.conectadot.app.modules.maisdetalhesabrigo.`data`.model.MaisDetalhesAbrigoModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import com.conectadot.app.appcomponents.SharedPreferences
import com.conectadot.app.appcomponents.di.MyApp
import com.conectadot.app.appcomponents.room.Animal


class MaisDetalhesAbrigoVM : ViewModel(), KoinComponent {
  val maisDetalhesAbrigoModel: MutableLiveData<MaisDetalhesAbrigoModel> =
      MutableLiveData(MaisDetalhesAbrigoModel())

    var navArguments: Bundle? = null

    fun getAnimalDetails(context: Context, id: Int){
        CoroutineScope(Dispatchers.Default).launch {
            val animal: Animal = DatabaseUtils.getAnimalDetails(context, id)
            maisDetalhesAbrigoModel.postValue(MaisDetalhesAbrigoModel(
                txtNomeKyuubi = context.getString(R.string.lbl_nome) + " " + animal.name,
                txtEspcieCachor = context.getString(R.string.msg_esp_cie_cachor) + " " + animal.species,
                txtRaaLuludaP = context.getString(R.string.lbl_race) + " " + animal.race,
                txtSexoFmea = null,
                txtIdade10meses = context.getString(R.string.lbl_idade_10_meses) + " " + animal.age,
                txtPortePequeno = context.getString(R.string.lbl_porte_pequeno) + " " + animal.size,
                txtStatuscastra = context.getString(R.string.msg_status_castra) + " " + animal.detailsc,
                txtStatusvacina = context.getString(R.string.msg_status_vacina) + " " + animal.detailsv,
                image = animal.image
            ))
        }
    }

}
