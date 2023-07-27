package com.conectadot.app.modules.listarchatsabrigousurio.`data`.model

import com.conectadot.app.R
import com.conectadot.app.appcomponents.di.MyApp
import kotlin.String

data class ListarChatsAbrigoUsuRioModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtMeuschats: String? = MyApp.getInstance().resources.getString(R.string.lbl_meus_chats)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtName: String? = MyApp.getInstance().resources.getString(R.string.msg_la_ador_abrigo)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSegueumaimage: String? =
      MyApp.getInstance().resources.getString(R.string.msg_segue_uma_image)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTime: String? = MyApp.getInstance().resources.getString(R.string.lbl_11_30_am)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFrame2891: String? = MyApp.getInstance().resources.getString(R.string.lbl_2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtNameOne: String? = MyApp.getInstance().resources.getString(R.string.msg_outro_abrigo_de)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtOii: String? = MyApp.getInstance().resources.getString(R.string.lbl_oii)

)
