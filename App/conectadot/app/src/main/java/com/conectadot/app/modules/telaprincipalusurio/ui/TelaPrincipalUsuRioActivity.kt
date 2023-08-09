package com.conectadot.app.modules.telaprincipalusurio.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.conectadot.app.R
import com.conectadot.app.appcomponents.base.BaseActivity
import com.conectadot.app.databinding.ActivityTelaPrincipalUsuRioBinding
import com.conectadot.app.modules.chatabrigousurio.ui.ChatAbrigoUsuRioActivity
import com.conectadot.app.modules.listarchatsabrigousurio.ui.ListarChatsAbrigoUsuRioActivity
import com.conectadot.app.modules.maisdetalhesusurio.ui.MaisDetalhesUsuRioBottomsheet
import com.conectadot.app.modules.telaprincipalusurio.`data`.viewmodel.TelaPrincipalUsuRioVM
import kotlin.String
import kotlin.Unit

class TelaPrincipalUsuRioActivity :
    BaseActivity<ActivityTelaPrincipalUsuRioBinding>(R.layout.activity_tela_principal_usu_rio) {
    private val viewModel: TelaPrincipalUsuRioVM by viewModels()

    override fun onInitialized() {
        viewModel.navArguments = intent.extras?.getBundle("bundle")
        binding.telaPrincipalUsuRioVM = viewModel
    }

    override fun setUpClicks() {
        binding.imageArrowup.setOnClickListener {
            val sheet = MaisDetalhesUsuRioBottomsheet()
            sheet.show(supportFragmentManager, "")
        }

        binding.linearColumnforward.setOnClickListener {
            startActivity(ChatAbrigoUsuRioActivity.getIntent(this, null))
        }

        binding.btnForward.setOnClickListener {
            startActivity(ChatAbrigoUsuRioActivity.getIntent(this, null))
        }

        binding.imageIconsaxBoldme.setOnClickListener {
            startActivity(ListarChatsAbrigoUsuRioActivity.getIntent(this, null))
            overridePendingTransition(R.anim.anim_pull_right, R.anim.anim_push_left)
        }
    }

    companion object {
        const val TAG: String = "TELA_PRINCIPAL_USU_RIO_ACTIVITY"

        fun getIntent(context: Context, bundle: Bundle?): Intent {
            val destIntent = Intent(context, TelaPrincipalUsuRioActivity::class.java)
            destIntent.putExtra("bundle", bundle)
            return destIntent
        }
    }
}
