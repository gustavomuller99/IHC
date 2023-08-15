package com.conectadot.app.modules.telaprincipalabrigo.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.conectadot.app.R
import com.conectadot.app.appcomponents.SharedPreferences
import com.conectadot.app.appcomponents.base.BaseActivity
import com.conectadot.app.databinding.ActivityTelaPrincipalAbrigoBinding
import com.conectadot.app.modules.login.data.viewmodel.LoginResult
import com.conectadot.app.modules.maisdetalhesabrigo.ui.MaisDetalhesAbrigoActivity
import com.conectadot.app.modules.novoeditaranimalabrigo.ui.NovoEditarAnimalAbrigoActivity
import com.conectadot.app.modules.telaprincipalabrigo.`data`.model.ListrectangleeightRowModel
import com.conectadot.app.modules.telaprincipalabrigo.`data`.viewmodel.TelaPrincipalAbrigoVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class TelaPrincipalAbrigoActivity :
    BaseActivity<ActivityTelaPrincipalAbrigoBinding>(R.layout.activity_tela_principal_abrigo) {
    private val viewModel: TelaPrincipalAbrigoVM by viewModels()

    override fun onInitialized() {
        viewModel.navArguments = intent.extras?.getBundle("bundle")
        viewModel.updateAnimalList(this)

        val listrectangleeightAdapter = ListrectangleeightAdapter(viewModel.listrectangleeightList.value ?: mutableListOf())
        listrectangleeightAdapter.setOnItemClickListener(object :
            ListrectangleeightAdapter.OnItemClickListener {
            override fun onItemClick(view: View, position: Int, item: ListrectangleeightRowModel) {
                onClickRecyclerListrectangleeight(view, position, item)
            }
        })

        binding.recyclerListrectangleeight.adapter = listrectangleeightAdapter

        viewModel.listrectangleeightList.observe(this) {
            if (it.isEmpty()) {
                binding.listEmpty.visibility = View.VISIBLE
                binding.recyclerListrectangleeight.visibility = View.GONE
            } else {
                binding.listEmpty.visibility = View.GONE
                binding.recyclerListrectangleeight.visibility = View.VISIBLE
                listrectangleeightAdapter.updateData(it)
            }
        }



        binding.floatingBtnFloatingactionbutton.setOnClickListener {
            startActivity(NovoEditarAnimalAbrigoActivity.getIntent(this, null))
        }

        binding.telaPrincipalAbrigoVM = viewModel
    }

    override fun setUpClicks() {
    }

    override fun onBackPressed() {
        SharedPreferences.setLoggedId(LoginResult.Failed.value)
        super.onBackPressed()
    }

    override fun onResume() {
        super.onResume()
        viewModel.updateAnimalList(this)
    }

    fun onClickRecyclerListrectangleeight(
        view: View,
        position: Int,
        item: ListrectangleeightRowModel
    ): Unit {
        startActivity(MaisDetalhesAbrigoActivity.getIntent(this, null))
    }

    companion object {
        const val TAG: String = "TELA_PRINCIPAL_ABRIGO_ACTIVITY"

        fun getIntent(context: Context, bundle: Bundle?): Intent {
            val destIntent = Intent(context, TelaPrincipalAbrigoActivity::class.java)
            destIntent.putExtra("bundle", bundle)
            return destIntent
        }
    }
}
