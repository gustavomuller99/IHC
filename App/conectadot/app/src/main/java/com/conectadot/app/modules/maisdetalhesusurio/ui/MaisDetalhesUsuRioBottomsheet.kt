package com.conectadot.app.modules.maisdetalhesusurio.ui

import androidx.fragment.app.viewModels
import com.conectadot.app.R
import com.conectadot.app.appcomponents.base.BaseBottomsheetDialogFragment
import com.conectadot.app.databinding.BottomsheetMaisDetalhesUsuRioBinding
import com.conectadot.app.modules.maisdetalhesusurio.`data`.viewmodel.MaisDetalhesUsuRioVM
import kotlin.String
import kotlin.Unit

class MaisDetalhesUsuRioBottomsheet :
    BaseBottomsheetDialogFragment<BottomsheetMaisDetalhesUsuRioBinding>(R.layout.bottomsheet_mais_detalhes_usu_rio)
    {
  private val viewModel: MaisDetalhesUsuRioVM by viewModels<MaisDetalhesUsuRioVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = arguments
    binding.maisDetalhesUsuRioVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "MAIS_DETALHES_USU_RIO_BOTTOMSHEET"

  }
}
