package com.conectadot.app.modules.detalhescontato.ui

import androidx.fragment.app.viewModels
import com.conectadot.app.R
import com.conectadot.app.appcomponents.base.BaseBottomsheetDialogFragment
import com.conectadot.app.databinding.BottomsheetDetalhesContatoBinding
import com.conectadot.app.modules.detalhescontato.data.viewmodel.DetalhesContatoViewModel

class DetalhesContatoActivity: BaseBottomsheetDialogFragment<BottomsheetDetalhesContatoBinding>(R.layout.bottomsheet_detalhes_contato) {

    private val viewModel: DetalhesContatoViewModel by viewModels()

    override fun onInitialized() {
        arguments?.getInt("id")?.let { id ->
            context?.let {
                viewModel.getShelter(it, id)
            }
        }

        viewModel.shelter.observe(viewLifecycleOwner) {
            binding.tvNome.text = getString(R.string.lbl_nome) + " " + it.name
            binding.tvCity.text = getString(R.string.lbl_cidade) + " " + it.city
            binding.tvEmail.text = getString(R.string.lbl_email) + " " + it.email
            binding.tvEnd.text = getString(R.string.lbl_endere_o) + " " + it.address
            binding.tvState.text = getString(R.string.lbl_estado) + " " + it.state
        }
    }

    override fun setUpClicks() {
        binding.imageArrowdown.setOnClickListener {
            dismiss()
        }
    }

}