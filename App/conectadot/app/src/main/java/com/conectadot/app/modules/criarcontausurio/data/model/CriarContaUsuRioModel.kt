package com.conectadot.app.modules.criarcontausurio.`data`.model

import com.conectadot.app.R
import com.conectadot.app.appcomponents.di.MyApp
import kotlin.String

data class CriarContaUsuRioModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtCriarconta: String? = MyApp.getInstance().resources.getString(R.string.lbl_criar_conta)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCadastrar: String? = MyApp.getInstance().resources.getString(R.string.lbl_cadastrar)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupSevenValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupSixValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupThreeValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupFiveValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupFourValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupTwoValue: String? = null
)
