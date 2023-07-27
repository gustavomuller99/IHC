package com.conectadot.app.modules.telaprincipalusurio.`data`.model

import com.conectadot.app.R
import com.conectadot.app.appcomponents.di.MyApp
import kotlin.String

data class TelaPrincipalUsuRioModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.lbl_nome_kyuubi)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAbrigoLaador: String? =
      MyApp.getInstance().resources.getString(R.string.msg_abrigo_la_ador)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDistance: String? = MyApp.getInstance().resources.getString(R.string.msg_dist_ncia_5_0)

)
