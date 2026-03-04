package com.example.bioskopapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bioskopapp.databinding.ActivityPaymentBinding

class PaymentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPaymentBinding
    private val hargaPerTiket = 50000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val film = intent.getStringExtra("FILM") ?: ""
        val jumlah = intent.getIntExtra("JUMLAH", 0)
        val total = jumlah * hargaPerTiket

        binding.tvFilm.text = "Film: $film"
        binding.tvJumlah.text = "Jumlah Tiket: $jumlah"
        binding.tvTotalHarga.text = "Total Harga: Rp $total"

        binding.btnBayar.setOnClickListener {
            val intentKonfirmasi = Intent(this, ConfirmationActivity::class.java)
            intentKonfirmasi.putExtra("FILM", film)
            intentKonfirmasi.putExtra("JUMLAH", jumlah)
            intentKonfirmasi.putExtra("TOTAL", total)
            startActivity(intentKonfirmasi)

            // kirim hasil ke ChooseSeatActivity
            setResult(Activity.RESULT_OK)
            finish()
        }

        binding.btnBatal.setOnClickListener {
            val returnIntent = Intent()
            returnIntent.putExtra("HASIL", "Pembayaran dibatalkan")
            setResult(Activity.RESULT_CANCELED, returnIntent)
            finish()
        }
    }
}