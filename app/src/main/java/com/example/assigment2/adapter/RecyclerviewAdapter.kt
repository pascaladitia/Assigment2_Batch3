package com.example.assigment2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assigment2.R
import com.example.assigment2.model.Anggota
import kotlinx.android.synthetic.main.list_item.view.*

class RecyclerviewAdapter(
    private val context: Context,
    private val data: List<Anggota>,
    private val itemCLick: OnClickListener
) : RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data?.get(position)

        holder.foto.setImageResource(item?.foto ?: 0)
        holder.nama.text= item?.nama

        holder.itemView.setOnClickListener {
            itemCLick.detail(item)
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var foto = view.list_image
        var nama = view.list_nama
    }

    interface OnClickListener {
        fun detail(item: Anggota)
    }
}