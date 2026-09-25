package com.example.lita_3tif.Pertemuan_4

import android.content.Intent // 1. Tambahkan import Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lita_3tif.Pertemuan_3.ThirdResultActivity
import com.example.lita_3tif.databinding.ActivityFourthBinding // 2. Import View Binding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

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
//        praktikum

        val name = intent.getStringExtra("name")
        val from = intent.getStringExtra("from")
        val age = intent.getIntExtra("age",0)
        Log.w("Data Intent","Nama: $name , Usia: $age, Asal: $from")

        binding.btnKembali.setOnClickListener {
            // Mengambil value teks dari EditText
            val no = binding.btnKembali.text.toString()

            // 6. Tentukan kelas tujuan di dalam Intent (misal: ThirdResultActivity)
            val intent = Intent(this, ThirdResultActivity::class.java)
            finish()
        }
        binding.btnShowSnackbar.setOnClickListener {
            Snackbar.make(binding.root, "Ini adalah Snackbar", Snackbar.LENGTH_SHORT)
                .setAction("Tampilkan"){
                    val intent = Intent(this, ThirdResultActivity::class.java)
                    startActivity(intent)
                    Log.e("Info Snackbar","Snackbar ditutup")
                }
                .show()
        }
//        alert
        binding.btnShowAlertDialog.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda sudah submit judul?")
                .setPositiveButton("Ya") { dialog, _ ->
                    dialog.dismiss()
                    Log.e("Info Dialog","Anda memilih Ya!")
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                    Log.e("Info Dialog","Anda memilih Tidak!")
                }
                .show()
        }

    }
}