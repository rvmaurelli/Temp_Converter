package br.com.rvmaurelli.temp_converter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val temprec = intent.getStringExtra("tempresulttxt")
        val unitrec = intent.getStringExtra("unidade")

        txvTempResultValue.text = temprec
        txvTempResultUnit.text = unitrec

        btnVoltar.setOnClickListener {
            startActivity(Intent(this@ResultActivity, MainActivity::class.java));finish()
        }
    }
}