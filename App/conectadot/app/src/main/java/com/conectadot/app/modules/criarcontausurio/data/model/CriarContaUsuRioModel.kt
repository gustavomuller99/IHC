package com.conectadot.app.modules.criarcontausurio.`data`.model

import com.conectadot.app.R
import com.conectadot.app.appcomponents.di.MyApp
import kotlin.String

data class CriarContaUsuRioModel(
  var txtCriarconta: String? = MyApp.getInstance().resources.getString(R.string.lbl_criar_conta),
  var txtCadastrar: String? = MyApp.getInstance().resources.getString(R.string.lbl_cadastrar),
  var etGroupSevenValue: String? = null,
  var etGroupSixValue: String? = null,
  var etGroupThreeValue: String? = null,
  var etGroupFiveValue: String? = null,
  var etGroupFourValue: String? = null,
  var etGroupTwoValue: String? = null
)
