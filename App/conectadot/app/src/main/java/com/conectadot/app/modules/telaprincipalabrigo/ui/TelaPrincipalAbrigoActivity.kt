package com.conectadot.app.modules.telaprincipalabrigo.ui

import android.view.View
import androidx.activity.viewModels
import com.conectadot.app.R
import com.conectadot.app.appcomponents.base.BaseActivity
import com.conectadot.app.databinding.ActivityTelaPrincipalAbrigoBinding
import com.conectadot.app.modules.telaprincipalabrigo.`data`.model.ListrectangleeightRowModel
import com.conectadot.app.modules.telaprincipalabrigo.`data`.viewmodel.TelaPrincipalAbrigoVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class TelaPrincipalAbrigoActivity :
    BaseActivity<ActivityTelaPrincipalAbrigoBinding>(R.layout.activity_tela_principal_abrigo) {
  private val viewModel: TelaPrincipalAbrigoVM by viewModels<TelaPrincipalAbrigoVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listrectangleeightAdapter =
    ListrectangleeightAdapter(viewModel.listrectangleeightList.value?:mutableListOf())
    binding.recyclerListrectangleeight.adapter = listrectangleeightAdapter
    listrectangleeightAdapter.setOnItemClickListener(
    object : ListrectangleeightAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : ListrectangleeightRowModel) {
        onClickRecyclerListrectangleeight(view, position, item)
      }
    }
    )
    viewModel.listrectangleeightList.observe(this) {
      listrectangleeightAdapter.updateData(it)
    }
    binding.telaPrincipalAbrigoVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  fun onClickRecyclerListrectangleeight(
    view: View,
    position: Int,
    item: ListrectangleeightRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "TELA_PRINCIPAL_ABRIGO_ACTIVITY"

  }
}
