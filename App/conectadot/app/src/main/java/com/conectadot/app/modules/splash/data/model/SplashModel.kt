package com.conectadot.app.modules.splash.`data`.model

import com.conectadot.app.R
import com.conectadot.app.appcomponents.di.MyApp
import kotlin.String

data class SplashModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtBemvindoaoCo: String? =
      MyApp.getInstance().resources.getString(R.string.msg_bem_vindo_ao_co)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMilharesdepet: String? =
      MyApp.getInstance().resources.getString(R.string.msg_milhares_de_pet)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtComeeagora: String? = MyApp.getInstance().resources.getString(R.string.lbl_come_e_agora)

)
