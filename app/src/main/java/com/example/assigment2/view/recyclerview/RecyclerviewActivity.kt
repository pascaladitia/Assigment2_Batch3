package com.example.assigment2.view.recyclerview

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import com.example.assigment2.R
import com.example.assigment2.adapter.RecyclerviewAdapter
import com.example.assigment2.model.Anggota
import kotlinx.android.synthetic.main.activity_recyclerview.*
import kotlinx.android.synthetic.main.detail_list_item.*

class RecyclerviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)

        initView()
    }

    private fun initView() {
        val list = ArrayList<Anggota>()
        list.add(
            Anggota("Ahmad Dahlan", R.drawable.ahmad_dahlan, "Indonesia")
        )
        list.add(Anggota("Ahmad Yani", R.drawable.ahmad_yani, "Indonesia")
        )
        list.add(Anggota("Bung Tomo", R.drawable.bung_tomo, "Indonesia")
        )
        list.add(Anggota("Gatot Subroto", R.drawable.gatot_subroto, "Indonesia")
        )
        list.add(Anggota("Sudirman", R.drawable.sudirman, "Indonesia")
        )
        list.add(Anggota("Sukarno", R.drawable.sukarno, "Indonesia")
        )
        list.add(Anggota("Supomo", R.drawable.supomo, "Indonesia")
        )

        recyclerView.adapter = RecyclerviewAdapter(this, list, object :
            RecyclerviewAdapter.OnClickListener {

            override fun detail(item: Anggota) {
                Dialog(this@RecyclerviewActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_list_item)

                    val image = this.detail_image
                    val nama = this.detail_nama
                    val alamat = this.detail_alamat
                    val close = this.btn_close

                    image.setImageResource(item.foto ?: 0)
                    nama.text = "Nama : ${item.nama}"
                    alamat.text = "Asal : ${item.alamat}"

                    close.setOnClickListener {
                        this.dismiss()
                    }
                }.show()
            }
        })
    }
}