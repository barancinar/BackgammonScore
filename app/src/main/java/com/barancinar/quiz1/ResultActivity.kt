package com.barancinar.quiz1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    private lateinit var tvKazanan: TextView
    private lateinit var btnTryAgain: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        initUI()
    }

    private fun initUI() {
        tvKazanan = findViewById(R.id.tvKazanan)
        btnTryAgain = findViewById(R.id.btnTryAgain)

        val winnerName = intent.extras?.getString(Intent.EXTRA_TEXT)
        tvKazanan.text = winnerName

        btnTryAgain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}