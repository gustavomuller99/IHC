package com.conectadot.app.modules.telaprincipalabrigo.ui

import android.graphics.ImageDecoder
import android.net.Uri
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.conectadot.app.R
import com.conectadot.app.databinding.RowListrectangleeightBinding
import com.conectadot.app.modules.telaprincipalabrigo.data.model.ListrectangleeightRowModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import java.net.URI


class ListrectangleeightAdapter(
    var list: List<ListrectangleeightRowModel>
) : RecyclerView.Adapter<ListrectangleeightAdapter.RowListrectangleeightVH>() {
    private var clickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListrectangleeightVH {
        val
            view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_listrectangleeight, parent, false)
        return RowListrectangleeightVH(view)
    }

    override fun onBindViewHolder(holder: RowListrectangleeightVH, position: Int) {
        holder.binding.listrectangleeightRowModel = list[position]

        holder.binding.root.setOnClickListener {
            clickListener?.onItemClick(holder.binding.root, position, list[position])
        }

        CoroutineScope(Dispatchers.Main).launch {
            list[position].image?.let {
                Uri.parse(it)?.let { uri ->
                    val bitmap = ImageDecoder.decodeBitmap(
                        ImageDecoder.createSource(
                            holder.binding.root.context.contentResolver,
                            uri
                        )
                    )
                    holder.binding.imageRectangleEight.setImageBitmap(bitmap)
                }
            } ?: holder.binding.imageRectangleEight.setImageDrawable(
                holder.binding.root.context.getDrawable(
                    R.drawable.dog
                )
            )
        }
    }

    override fun getItemCount(): Int = list.size

    public fun updateData(newData: List<ListrectangleeightRowModel>) {
        list = newData
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(clickListener: OnItemClickListener) {
        this.clickListener = clickListener
    }

    interface OnItemClickListener {
        fun onItemClick(
            view: View,
            position: Int,
            item: ListrectangleeightRowModel
        ) {
        }
    }

    inner class RowListrectangleeightVH(
        view: View
    ) : RecyclerView.ViewHolder(view) {
        val binding: RowListrectangleeightBinding = RowListrectangleeightBinding.bind(itemView)
    }
}
