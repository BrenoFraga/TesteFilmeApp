package com.example.teste.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teste.view.adapters.ParentAdapter
import com.example.teste.databinding.ActivityTelaPrincipalBinding

class TelaPrincipalActivity : AppCompatActivity() {
    private lateinit var binding : ActivityTelaPrincipalBinding
    private lateinit var adapterMain : ParentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapterMain = ParentAdapter()
        binding.recyclerMain.apply { layoutManager = LinearLayoutManager(this@TelaPrincipalActivity)
        adapter = adapterMain
        }
    }
}