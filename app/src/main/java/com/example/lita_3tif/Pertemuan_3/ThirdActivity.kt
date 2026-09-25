package com.example.lita_3tif.Pertemuan_3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lita_3tif.R
import com.example.lita_3tif.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
//    pertama
    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_third)

        binding= ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Inisialisasi komponen - SUDAH TIDAK DI PAKAI
//        val inputNoTujuan: EditText = findViewById(R.id.inputNoTujuan)
//        val btnKirim: Button = findViewById(R.id.btnKirim)

//        pakai binding
        binding.btnKirim.setOnClickListener {
            //Mengambil value dari inputNama dan menampilkan di Logcat
            val no = binding.inputNoTujuan.text

            val intent = Intent(this, ThirdResultActivity::class.java)
            startActivity(intent)

            Log.e("Klik btnSubmit","Pesan berhasil dikirim ke $no")

            Toast.makeText(this, "Pesan berhasil dikirim ke $no", Toast.LENGTH_SHORT).show()


        }
    }
}