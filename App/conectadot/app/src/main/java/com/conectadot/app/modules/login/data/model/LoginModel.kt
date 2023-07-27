package com.conectadot.app.modules.login.`data`.model

import com.conectadot.app.R
import com.conectadot.app.appcomponents.di.MyApp
import kotlin.String

data class LoginModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtEntrar: String? = MyApp.getInstance().resources.getString(R.string.lbl_entrar)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPorfavorentre: String? =
      MyApp.getInstance().resources.getString(R.string.msg_por_favor_entre)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtEmailaddress: String? = MyApp.getInstance().resources.getString(R.string.lbl_email_address)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtEsqueceuasenh: String? =
      MyApp.getInstance().resources.getString(R.string.msg_esqueceu_a_senh)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtNopossuicont: String? =
      MyApp.getInstance().resources.getString(R.string.msg_n_o_possui_cont)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAbrigodeanima: String? =
      MyApp.getInstance().resources.getString(R.string.msg_abrigo_de_anima)

)
