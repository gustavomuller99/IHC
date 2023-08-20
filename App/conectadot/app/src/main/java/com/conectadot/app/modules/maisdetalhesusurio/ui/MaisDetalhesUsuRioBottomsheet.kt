package com.conectadot.app.modules.maisdetalhesusurio.ui

import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.viewModels
import com.conectadot.app.R
import com.conectadot.app.appcomponents.base.BaseBottomsheetDialogFragment
import com.conectadot.app.databinding.BottomsheetMaisDetalhesUsuRioBinding
import com.conectadot.app.modules.maisdetalhesusurio.`data`.viewmodel.MaisDetalhesUsuRioVM
import kotlin.String
import kotlin.Unit

class MaisDetalhesUsuRioBottomsheet :
    BaseBottomsheetDialogFragment<BottomsheetMaisDetalhesUsuRioBinding>(R.layout.bottomsheet_mais_detalhes_usu_rio) {
    private val viewModel: MaisDetalhesUsuRioVM by viewModels<MaisDetalhesUsuRioVM>()

    override fun onInitialized(): Unit {
        viewModel.navArguments = arguments
        binding.maisDetalhesUsuRioVM = viewModel

        arguments?.getInt("animal_uid")?.let {
            context?.let { cur_context ->
                viewModel.getAnimal(cur_context, it)
            }
        }

        viewModel.animal.observe(viewLifecycleOwner) {
            binding.txtNomeKyuubi.text = "Nome: " + it.name
            binding.txtEspcieCachor.text = "Espécie: " + it.species
            binding.txtRaaLuludaP.text = "Raça: " + it.race
            binding.txtIdade10meses.text = "Idade: " + it.age
            binding.txtPortePequeno.text = "Porte: " + it.size
            binding.txtStatuscastra.text = "Status castração: " + it.detailsc
            binding.txtStatusvacina.text = "Status vacinação: " + it.detailsv

            it.image?.let {
                Uri.parse(it)?.let { uri ->
                    val bitmap = ImageDecoder.decodeBitmap(
                        ImageDecoder.createSource(
                            requireContext().contentResolver,
                            uri
                        )
                    )
                    binding.imageEllipseTwo.setImageBitmap(bitmap)
                }
            } ?: binding.imageEllipseTwo.setImageDrawable(
                requireContext().getDrawable(
                    R.drawable.dog
                )
            )

        }

    }

    override fun setUpClicks(): Unit {
        binding.imageArrowdown.setOnClickListener {
            dismiss()
        }
    }

    companion object {
        const val TAG: String = "MAIS_DETALHES_USU_RIO_BOTTOMSHEET"

    }
}
