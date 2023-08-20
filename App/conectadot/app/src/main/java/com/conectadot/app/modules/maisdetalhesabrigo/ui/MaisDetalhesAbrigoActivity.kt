package com.conectadot.app.modules.maisdetalhesabrigo.ui

import android.content.Context
import android.content.Intent
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.conectadot.app.R
import com.conectadot.app.appcomponents.base.BaseActivity
import com.conectadot.app.databinding.ActivityMaisDetalhesAbrigoBinding
import com.conectadot.app.modules.maisdetalhesabrigo.`data`.viewmodel.MaisDetalhesAbrigoVM
import com.conectadot.app.modules.novoeditaranimalabrigo.ui.NovoEditarAnimalAbrigoActivity
import kotlin.String
import kotlin.Unit

class MaisDetalhesAbrigoActivity :
    BaseActivity<ActivityMaisDetalhesAbrigoBinding>(R.layout.activity_mais_detalhes_abrigo) {
    private val viewModel: MaisDetalhesAbrigoVM by viewModels()

    override fun onInitialized() {
        viewModel.navArguments = intent.extras?.getBundle("bundle")
        binding.maisDetalhesAbrigoVM = viewModel

        viewModel.navArguments?.getInt("id", -1)?.let {
            viewModel.getAnimalDetails(this, it)
        }

        viewModel.maisDetalhesAbrigoModel.observe(this) {
            it.image?.let {
                Uri.parse(it)?.let { uri ->
                    val bitmap = ImageDecoder.decodeBitmap(
                        ImageDecoder.createSource(
                            contentResolver,
                            uri
                        )
                    )
                    binding.imageEllipseTwo.setImageBitmap(bitmap)
                }
            } ?: binding.imageEllipseTwo.setImageDrawable(
                getDrawable(
                    R.drawable.dog
                )
            )
        }
    }

    override fun setUpClicks() {
        binding.linearRowarrowleft.setOnClickListener {
            finish()
        }

        binding.floatingBtnFloatingactionbutton.setOnClickListener {
            startActivity(NovoEditarAnimalAbrigoActivity.getIntent(this, null))
        }
    }

    companion object {
        const val TAG: String = "MAIS_DETALHES_ABRIGO_BOTTOMSHEET"

        fun getIntent(context: Context, bundle: Bundle?): Intent {
            val destIntent = Intent(context, MaisDetalhesAbrigoActivity::class.java)
            destIntent.putExtra("bundle", bundle)
            return destIntent
        }
    }
}
