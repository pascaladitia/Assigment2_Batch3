package com.example.assigment2.view.listView

import android.app.Dialog
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import com.example.assigment2.R
import com.example.assigment2.adapter.ListViewAdapter
import com.example.assigment2.model.Anggota
import com.example.assigment2.model.Hero
import kotlinx.android.synthetic.main.detail_list_item.*

class ListViewActivity : AppCompatActivity() {

    private lateinit var adapter: ListViewAdapter
    private lateinit var dataName: Array<String>
    private lateinit var dataDescription: Array<String>
    private lateinit var dataPhoto: TypedArray
    private var anggota = arrayListOf<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        initView()
    }

    private fun initView() {
        val listView: ListView = findViewById(R.id.lv_list)

        adapter = ListViewAdapter(this)

        listView.adapter = adapter

        prepare()
        addItem()

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(applicationContext, anggota[position].name, Toast.LENGTH_SHORT).show()
            Dialog(this@ListViewActivity).apply {
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setCancelable(true)
                setContentView(R.layout.detail_list_item)

                val image = this.detail_image
                val nama = this.detail_nama
                val alamat = this.detail_alamat
                val close = this.btn_close

                image.setImageResource(anggota[position].photo)
                nama.text = "Nama : ${anggota[position].name}"
                alamat.text = "Deskripsi : ${anggota[position].description}"

                close.setOnClickListener {
                    this.dismiss()
                }
            }.show()
        }
    }

    private fun prepare() {
        dataName = resources.getStringArray(R.array.data_name)
        dataDescription = resources.getStringArray(R.array.data_description)
        dataPhoto = resources.obtainTypedArray(R.array.data_photo)
    }

    private fun addItem() {
        for (position in dataName.indices) {
            val hero = Hero(
                dataPhoto.getResourceId(position, -1),
                dataName[position],
                dataDescription[position]
            )
            anggota.add(hero)
        }
        adapter.item = anggota
    }
}