package com.example.bioskopapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.bioskopapp.databinding.ActivityChooseSeatBinding

class ChooseSeatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChooseSeatBinding

    private val paymentLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                // pembayaran sukses -> tutup choose seat -> kembali ke home
                finish()
            } else if (result.resultCode == Activity.RESULT_CANCELED) {
                val pesan = result.data?.getStringExtra("HASIL") ?: "Pembayaran dibatalkan"
                Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChooseSeatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val film = intent.getStringExtra("FILM") ?: "Tidak diketahui"
        binding.tvFilmTerpilih.text = "Film: $film"

        binding.btnLanjut.setOnClickListener {
            val jumlahStr = binding.etJumlahTiket.text.toString()

            if (jumlahStr.isEmpty()) {
                Toast.makeText(this, "Masukkan jumlah tiket", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val jumlah = jumlahStr.toInt()
            if (jumlah <= 0 || jumlah > 10) {
                Toast.makeText(this, "Jumlah tiket harus 1-10", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, PaymentActivity::class.java)
            intent.putExtra("FILM", film)
            intent.putExtra("JUMLAH", jumlah)
            paymentLauncher.launch(intent)
        }
    }
}