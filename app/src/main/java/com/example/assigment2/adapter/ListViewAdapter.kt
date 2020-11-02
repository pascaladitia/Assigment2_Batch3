package com.example.assigment2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.assigment2.R
import com.example.assigment2.model.Hero
import kotlinx.android.synthetic.main.list_item.view.*

class ListViewAdapter internal constructor
    (private val context: Context): BaseAdapter() {
    internal var item = arrayListOf<Hero>()

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false)
        }
        val viewHolder = ViewHolder(itemView as View)
        val hero = getItem(position) as Hero
        viewHolder.bind(hero)
        return itemView
    }

    override fun getItem(i: Int): Any = item[i]

    override fun getItemId(i: Int): Long = i.toLong()

    override fun getCount(): Int = item.size

    private inner class ViewHolder internal constructor(view: View) {
        val name = view.list_nama
        val image = view.list_image

        internal fun bind(hero: Hero) {
            name.text = hero.name
            hero.photo?.let { image.setImageResource(it) }
        }
    }
}