package br.com.rvmaurelli.temp_converter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.os.postDelayed

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        //Iniciar pela tela de splash, esperar 3 segundos e ir para tela main
        Handler().postDelayed({startActivity(Intent(this@SplashActivity, MainActivity::class.java));finish()},3000)
    }
}