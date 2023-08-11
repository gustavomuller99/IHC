package com.conectadot.app.modules.novoeditaranimalabrigo.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.conectadot.app.R
import com.conectadot.app.appcomponents.base.BaseActivity
import com.conectadot.app.databinding.ActivityNovoEditarAnimalAbrigoBinding
import com.conectadot.app.modules.login.ui.LoginActivity
import com.conectadot.app.modules.maisdetalhesabrigo.ui.MaisDetalhesAbrigoActivity
import com.conectadot.app.modules.novoeditaranimalabrigo.`data`.viewmodel.NovoEditarAnimalAbrigoVM
import com.conectadot.app.modules.telaprincipalabrigo.ui.TelaPrincipalAbrigoActivity
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
      override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var portestr: String
        portestr = ""
        binding.btnConfirm.setOnClickListener {
          if(binding.txtAnimalName.text.isNotEmpty()){
            if(binding.txtAnimalSpecies.text.isNotEmpty()){
              if(binding.txtAnimalSpecies.text.toString().uppercase() == "CACHORRO" || binding.txtAnimalSpecies.text.toString().uppercase() == "GATO"){
                if(binding.txtAnimalRace.text.isNotEmpty()){
                  if(binding.txtAnimalAge.text.isNotEmpty()){
                    if(binding.txtDetailsC.text.isNotEmpty() && binding.txtDetailsV.text.isNotEmpty()){
                      if(binding.rbPequeno.isChecked || binding.rbMdio.isChecked || binding.rbGrande.isChecked){
                        if(binding.rbPequeno.isChecked){
                          portestr = "Pequeno"
                        }
                        else if(binding.rbMdio.isChecked){
                          portestr = "Medio"
                        }
                        else if(binding.rbGrande.isChecked){
                          portestr = "Grande"
                        }
                        startActivity(TelaPrincipalAbrigoActivity.getIntent(this, null))
                      }else{
                        Toast.makeText(this, "Informe o porte do animal.", Toast.LENGTH_SHORT)
                          .show()
                      }
                    }else{
                      Toast.makeText(this, "Informe detalhes de castração e vacina.", Toast.LENGTH_SHORT)
                        .show()
                    }
                  }else{
                    Toast.makeText(this, "Informe a idade do animal.", Toast.LENGTH_SHORT)
                      .show()
                  }
                }else{
                  Toast.makeText(this, "Informe a raça do animal.", Toast.LENGTH_SHORT)
                    .show()
                }
              }else{
                Toast.makeText(this, "Espécie deve ser cachorro ou gato.", Toast.LENGTH_SHORT)
                  .show()
              }
            }else{
              Toast.makeText(this, "Informe a espécie do animal.", Toast.LENGTH_SHORT)
                .show()
            }
          }else{
            Toast.makeText(this, "Informe o nome do animal.", Toast.LENGTH_SHORT)
              .show()
          }
        }
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
