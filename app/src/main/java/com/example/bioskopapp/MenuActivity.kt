package com.example.bioskopapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.bioskopapp.DetailActivity

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)

        val nama = intent.getStringExtra("nama")
        val nim = intent.getStringExtra("nim")

        tvWelcome.text = "Selamat datang $nama ($nim)"

        val btn1 = findViewById<Button>(R.id.btnMenu1)
        val btn2 = findViewById<Button>(R.id.btnMenu2)
        val btn3 = findViewById<Button>(R.id.btnMenu3)

        btn1.setOnClickListener {

            bukaDetail("Nasi Goreng",15000)

        }

        btn2.setOnClickListener {

            bukaDetail("Mie Ayam",12000)

        }

        btn3.setOnClickListener {

            bukaDetail("Ayam Geprek",18000)

        }

    }

    private fun bukaDetail(menu:String, harga:Int){

        val nama = intent.getStringExtra("nama")
        val nim = intent.getStringExtra("nim")

        val intent = Intent(this, DetailActivity::class.java)

        intent.putExtra("nama",nama)
        intent.putExtra("nim",nim)
        intent.putExtra("menu",menu)
        intent.putExtra("harga",harga)

        startActivity(intent)

    }

}