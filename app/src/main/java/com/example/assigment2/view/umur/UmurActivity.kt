package com.example.assigment2.view.umur

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.assigment2.R
import kotlinx.android.synthetic.main.activity_umur.*
import java.util.*


class UmurActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_umur)

        initView()
    }

    private fun initView() {
        btn_hitungUmur.setOnClickListener {

            var tahunLahir = umur_input.text.toString().toInt()
            var tahun: Int = Calendar.getInstance().get(Calendar.YEAR)
            var umur = tahun - tahunLahir

            //hasil
            umur_hasil.text = "Umur anda saat ini adalah $umur tahun"
        }

        btn_hitungUmurBack.setOnClickListener {
            onBackPressed()
            finish()
        }
    }
}