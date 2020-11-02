package com.example.assigment2.view.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.assigment2.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when(view.id) {
            R.id.btn_login -> {
                login()
            }
        }
    }

    private fun login() {
        val user = login_username.text.toString()
        val pass = login_password.text.toString()

        if (user.isEmpty() || pass.isEmpty()) {
            Toast.makeText(this, "Usernama dan Password tidak boleh kosong", Toast.LENGTH_SHORT).show()
            return
        }

        if (user == "pascaladitia@gmail.com" && pass == "12345678") {
            val intent = Intent(this@MainActivity, DashboardActivity::class.java)
            startActivity(intent)
            finish()
        }
        else {
            Toast.makeText(this, "user atau password salah", Toast.LENGTH_SHORT).show()
        }
    }
}