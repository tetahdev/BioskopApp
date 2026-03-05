package com.example.bioskopapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.bioskopapp.MenuActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNama = findViewById<EditText>(R.id.etNama)
        val etNim = findViewById<EditText>(R.id.etNim)
        val spKelas = findViewById<Spinner>(R.id.spKelas)
        val btnMasuk = findViewById<Button>(R.id.btnMasuk)

        val kelasList = arrayOf("2AEC1","2AEC2","2AEC3","2AEC4")

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            kelasList
        )

        spKelas.adapter = adapter

        btnMasuk.setOnClickListener {

            val nama = etNama.text.toString()
            val nim = etNim.text.toString()
            val kelas = spKelas.selectedItem.toString()

            if(nama.isEmpty() || nim.isEmpty()){

                Toast.makeText(
                    this,
                    "Nama dan NIM tidak boleh kosong",
                    Toast.LENGTH_SHORT
                ).show()

            }else{

                val intent = Intent(this, MenuActivity::class.java)

                intent.putExtra("nama",nama)
                intent.putExtra("nim",nim)
                intent.putExtra("kelas",kelas)

                startActivity(intent)

            }

        }

    }

}