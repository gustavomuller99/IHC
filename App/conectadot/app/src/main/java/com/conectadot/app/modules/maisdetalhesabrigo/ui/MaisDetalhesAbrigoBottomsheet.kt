package com.conectadot.app.modules.maisdetalhesabrigo.ui

import androidx.fragment.app.viewModels
import com.conectadot.app.R
import com.conectadot.app.appcomponents.base.BaseBottomsheetDialogFragment
import com.conectadot.app.databinding.BottomsheetMaisDetalhesAbrigoBinding
import com.conectadot.app.modules.maisdetalhesabrigo.`data`.viewmodel.MaisDetalhesAbrigoVM
import kotlin.String
import kotlin.Unit

class MaisDetalhesAbrigoBottomsheet :
    BaseBottomsheetDialogFragment<BottomsheetMaisDetalhesAbrigoBinding>(R.layout.bottomsheet_mais_detalhes_abrigo)
    {
  private val viewModel: MaisDetalhesAbrigoVM by viewModels<MaisDetalhesAbrigoVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = arguments
    binding.maisDetalhesAbrigoVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "MAIS_DETALHES_ABRIGO_BOTTOMSHEET"

  }
}
