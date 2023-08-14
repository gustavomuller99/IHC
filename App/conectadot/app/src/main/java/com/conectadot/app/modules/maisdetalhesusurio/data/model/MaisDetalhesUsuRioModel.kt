package com.conectadot.app.modules.maisdetalhesusurio.`data`.model

import com.conectadot.app.R
import com.conectadot.app.appcomponents.di.MyApp
import kotlin.String

data class MaisDetalhesUsuRioModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtNomeKyuubi: String? = MyApp.getInstance().resources.getString(R.string.lbl_nome)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtEspcieCachor: String? =
      MyApp.getInstance().resources.getString(R.string.msg_esp_cie_cachor)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtRaaLuludaP: String? = MyApp.getInstance().resources.getString(R.string.lbl_race)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSexoFmea: String? = MyApp.getInstance().resources.getString(R.string.lbl_sexo_f_mea)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtIdade10meses: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_idade_10_meses)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPortePequeno: String? = MyApp.getInstance().resources.getString(R.string.lbl_porte_pequeno)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtStatuscastra: String? = MyApp.getInstance().resources.getString(R.string.msg_status_castra)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtStatusvacina: String? = MyApp.getInstance().resources.getString(R.string.msg_status_vacina)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtInformaesadi: String? =
      MyApp.getInstance().resources.getString(R.string.msg_informa_es_adi)

)
