package com.conectadot.app.modules.criarcontaabrigo.`data`.model

import com.conectadot.app.R
import com.conectadot.app.appcomponents.di.MyApp
import kotlin.String

data class CriarContaAbrigoModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtCadastrarabrig: String? =
      MyApp.getInstance().resources.getString(R.string.msg_cadastrar_abrig)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupSeventeenValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupSixteenValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupTwelveValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupFifteenValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupFourteenValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupThirteenValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupElevenValue: String? = null
)
