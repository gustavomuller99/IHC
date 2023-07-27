package com.conectadot.app.modules.telaprincipalabrigo.`data`.model

import com.conectadot.app.R
import com.conectadot.app.appcomponents.di.MyApp
import kotlin.String

data class ListrectangleeightRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtNomeKyuubi: String? = MyApp.getInstance().resources.getString(R.string.lbl_nome_kyuubi2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtRaaLuludaP: String? = MyApp.getInstance().resources.getString(R.string.msg_ra_a_lulu_da_p)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPortePequeno: String? = MyApp.getInstance().resources.getString(R.string.lbl_porte_pequeno)

)
