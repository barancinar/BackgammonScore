package com.barancinar.quiz1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var etOyuncu1: EditText
    private lateinit var etOyuncu2: EditText
    private lateinit var btnNewGame: Button
    private lateinit var tvSkor: TextView
    private lateinit var button1: Button
    private lateinit var button2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()
    }


    private fun initUI() {
        etOyuncu1 = findViewById(R.id.etOyuncu1)
        etOyuncu2 = findViewById(R.id.etOyuncu2)
        btnNewGame = findViewById(R.id.btnNewGame)
        tvSkor = findViewById(R.id.tvSkor)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)

        var oyuncuSkor1: Int = 0
        var oyuncuSkor2: Int = 0
        var name1: String?=null
        var name2: String?=null

        btnNewGame.setOnClickListener {
            name1 = etOyuncu1.text.toString()
            name2 = etOyuncu2.text.toString()
            button1.text = "$name1 Kazandı"
            button2.text = "$name2 Kazandı"

            tvSkor.text = "$oyuncuSkor1 - $oyuncuSkor2"

            button1.isEnabled = true
            button2.isEnabled = true
        }

        button1.setOnClickListener {
            oyuncuSkor1 += 1
            if(oyuncuSkor1 == 5) {
                val intent = Intent(this, ResultActivity::class.java)
                val bundle = Bundle()
                bundle.putString(Intent.EXTRA_TEXT, name1)
                intent.putExtras(bundle)
                startActivity(intent)
            }else {
                tvSkor.text = "$oyuncuSkor1 - $oyuncuSkor2"
            }
        }
        button2.setOnClickListener {
            oyuncuSkor2 += 1
            if(oyuncuSkor2 == 5) {
                val intent = Intent(this, ResultActivity::class.java)
                val bundle = Bundle()
                bundle.putString(Intent.EXTRA_TEXT, name2)
                intent.putExtras(bundle)
                startActivity(intent)
            }else {
                tvSkor.text = "$oyuncuSkor1 - $oyuncuSkor2"
            }
        }
    }
}