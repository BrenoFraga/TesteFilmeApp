package com.example.teste.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import com.example.teste.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        startScreen()
    }

    private fun startScreen() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, TelaInicialActivity::class.java)
            startActivity(intent)
            finish()
        }, 1000)
    }
}