package com.conectadot.app.modules.novoeditaranimalabrigo.`data`.model

import com.conectadot.app.R
import com.conectadot.app.appcomponents.di.MyApp
import kotlin.String

data class NovoEditarAnimalAbrigoModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtNovoanimal: String? = MyApp.getInstance().resources.getString(R.string.lbl_novo_animal)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPorte: String? = MyApp.getInstance().resources.getString(R.string.lbl_porte2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupThirtySixValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupThirtyFiveValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupThirtyTwoValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupThirtyFourValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupThirtyThreeValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupThirtyOneValue: String? = null
)
