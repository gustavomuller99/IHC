package com.conectadot.app.modules.novoeditaranimalabrigo.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.conectadot.app.R
import com.conectadot.app.appcomponents.base.BaseActivity
import com.conectadot.app.databinding.ActivityNovoEditarAnimalAbrigoBinding
import com.conectadot.app.modules.maisdetalhesabrigo.ui.MaisDetalhesAbrigoActivity
import com.conectadot.app.modules.novoeditaranimalabrigo.`data`.viewmodel.NovoEditarAnimalAbrigoVM
import kotlin.String
import kotlin.Unit

class NovoEditarAnimalAbrigoActivity :
    BaseActivity<ActivityNovoEditarAnimalAbrigoBinding>(R.layout.activity_novo_editar_animal_abrigo)
    {
  private val viewModel: NovoEditarAnimalAbrigoVM by viewModels<NovoEditarAnimalAbrigoVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.novoEditarAnimalAbrigoVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "NOVO_EDITAR_ANIMAL_ABRIGO_ACTIVITY"

    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, NovoEditarAnimalAbrigoActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
