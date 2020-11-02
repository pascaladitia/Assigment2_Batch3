package com.example.assigment2.view.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.assigment2.R
import com.example.assigment2.view.calculator.CalculatorActivity
import com.example.assigment2.view.listView.ListViewActivity
import com.example.assigment2.view.recyclerview.RecyclerviewActivity
import com.example.assigment2.view.umur.UmurActivity
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        btn_calculator.setOnClickListener(this)
        btn_recyclerview.setOnClickListener(this)
        btn_hitungUmur.setOnClickListener(this)
        btn_listView.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when(view.id) {
            R.id.btn_calculator -> {
                val intent = Intent(this@DashboardActivity, CalculatorActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_recyclerview -> {
                val intent = Intent(this@DashboardActivity, RecyclerviewActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_hitungUmur -> {
                val intent = Intent(this@DashboardActivity, UmurActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_listView -> {
                val intent = Intent(this@DashboardActivity, ListViewActivity::class.java)
                startActivity(intent)
            }
        }
    }
}