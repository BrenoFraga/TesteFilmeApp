package com.example.teste.view.activities

import FilmeViewModel
import android.content.ContentValues
import android.graphics.Insets.add
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.koin.android.ext.android.inject
import androidx.fragment.app.commit
import androidx.lifecycle.Observer
import com.example.teste.R
import com.example.teste.databinding.ActivityMasterBinding
import com.example.teste.databinding.BottomNavigationBinding
import com.example.teste.view.fragments.ConfigFragment
import com.example.teste.view.fragments.HomeFragment
import com.example.teste.view.fragments.SearchFragment
import com.example.teste.view.internet.RetrofitService
import com.example.teste.view.models.FilmeVO
import com.example.teste.view.repositories.MovieRepository
import com.example.teste.view.viewModels.MyViewModelFactory
import java.util.ArrayList

class MasterActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMasterBinding
    private val viewModel : FilmeViewModel by inject()
    val fragmentConfig = ConfigFragment()
    val fragmentHome = HomeFragment()
    val fragmentSerach = SearchFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMasterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        initListeners()
        replaceFragment(fragmentHome)
    }

    private fun initListeners() {
        with(binding){
            navBar.setOnItemSelectedListener {
                when(it.itemId){
                    R.id.home -> {
                        replaceFragment(fragmentHome)

                    }
                    R.id.perfil -> {
                        replaceFragment(fragmentConfig)

                    }
                    R.id.search -> {
                        replaceFragment(fragmentSerach)

                    }
                    else ->{}
                }
                true
            }
        }
    }

    private fun replaceFragment(fragment:Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}