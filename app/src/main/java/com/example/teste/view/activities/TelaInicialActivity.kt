package com.example.teste.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.teste.databinding.ActivityTelaInicialBinding

class TelaInicialActivity : AppCompatActivity() {

    private lateinit var binding : ActivityTelaInicialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaInicialBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()
        initListeners()
    }

    private fun initListeners() {
        with(binding){
           buttonLogin.setOnClickListener {
               startActivity(Intent(this@TelaInicialActivity, MainActivity::class.java))
           }

           butonCadastrar.setOnClickListener {
               startActivity(Intent(this@TelaInicialActivity, CadastroActivity::class.java))
           }
        }
    }
}