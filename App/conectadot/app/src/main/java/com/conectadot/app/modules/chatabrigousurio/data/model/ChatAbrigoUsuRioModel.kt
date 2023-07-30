package com.conectadot.app.modules.chatabrigousurio.`data`.model

import com.conectadot.app.R
import com.conectadot.app.appcomponents.di.MyApp
import kotlin.String

data class ChatAbrigoUsuRioModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtLaadorAbrigo: String? =
      MyApp.getInstance().resources.getString(R.string.msg_la_ador_abrigo2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtName: String? = MyApp.getInstance().resources.getString(R.string.msg_la_ador_abrigo)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTime: String? = MyApp.getInstance().resources.getString(R.string.lbl_11_30_am)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtEsseodog: String? = MyApp.getInstance().resources.getString(R.string.lbl_esse_o_dog)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTimeOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_11_30_am)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTimeTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_11_31_am)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMensagem: String? = ""
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etTextValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etTextOneValue: String? = null
)
