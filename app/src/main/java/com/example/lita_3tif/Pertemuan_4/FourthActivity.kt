package com.example.lita_3tif.Pertemuan_4

import android.content.Intent // 1. Tambahkan import Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lita_3tif.Pertemuan_3.ThirdResultActivity
import com.example.lita_3tif.databinding.ActivityFourthBinding // 2. Import View Binding

class FourthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFourthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // 4. Inisialisasi View Binding
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 5. Atur Window Insets menggunakan binding.main
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnKembali.setOnClickListener {
            // Mengambil value teks dari EditText
            val no = binding.btnKembali.text.toString()

            // 6. Tentukan kelas tujuan di dalam Intent (misal: ThirdResultActivity)
            val intent = Intent(this, ThirdResultActivity::class.java)
            finish()
        }
    }
}