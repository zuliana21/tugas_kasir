package com.example.kasirz

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val namaPembeli = findViewById<EditText>(R.id.txtNamaPembeli)
        val namaBarang = findViewById<EditText>(R.id.txtNamaBarang)
        val jumlahPembeli = findViewById<EditText>(R.id.txtJumlahBeli)
        val harga = findViewById<EditText>(R.id.txtHarga)
        val uangBayar = findViewById<EditText>(R.id.txtUangBayar)
        val btnProses = findViewById<Button>(R.id.btnProses)
        val totalBelanja = findViewById<TextView>(R.id.txtTotalBelanja)
        val Kembalian = findViewById<TextView>(R.id.txtUangKembalian)
        val bonus = findViewById<TextView>(R.id.txtBonus)
        val Keterangan = findViewById<TextView>(R.id.txtKeterangan)
        val btnReset = findViewById<Button>(R.id.btnReset)

        btnProses.setOnClickListener {
            var total: Int = 0
            val jmlBeli = Integer.parseInt(jumlahPembeli.text.toString())
            val hrg = Integer.parseInt(harga.text.toString())
            val bayar = Integer.parseInt(uangBayar.text.toString())

            total = jmlBeli * hrg
            val kembali = bayar - total

            totalBelanja.text = "Total Belanja:" + total.toString()
            Kembalian.text = "Uang Kembali: " + kembali.toString()

            if (bayar == total) {
                Keterangan.text = "Keterangan : Uang Pas"
            }
            if (bayar < total) {
                Keterangan.text = "Keterangan : Kurang Bayar "+ abs(kembali)
            }
            if (bayar > total) {
                Keterangan.text = "Keterangan : Kembalian "+ kembali
            }

            if (total >= 200000) {
                bonus.text = "Bonus: Mouse"
            }else if (total >= 400000) {
                bonus.text = "Bonus Keyboard"
            }else if (total >= 600000){
                bonus.text = "Bonus Harrdisk"
            }else {
                bonus.text = "Bonus: Tidak Ada Bonus"
            }
        }

        btnReset.setOnClickListener {
            namaPembeli.setText("")
            namaBarang.setText("")
            jumlahPembeli.setText("")
            harga.setText("")
            uangBayar.setText("")
            totalBelanja.setText("Total Belanja:")
            Kembalian.setText("Uang Kembalian:")
            bonus.setText("Bonus:")
            Keterangan.setText("Keterangan")
        }

    }
}