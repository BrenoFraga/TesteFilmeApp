package com.example.teste.view.fragments

import FilmeViewModel
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teste.R
import com.example.teste.databinding.FragmentHomeBinding
import com.example.teste.view.adapters.ParentAdapter
import com.example.teste.view.internet.RetrofitService.Companion.retrofitService
import com.example.teste.view.models.FilmeVO
import com.example.teste.view.repositories.MovieRepository
import com.example.teste.view.viewModels.MyViewModelFactory

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment() : Fragment() {

    private var adapterMain : ParentAdapter? = null
    private  var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private  val viewModel: FilmeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        initRecyclerView()
        return binding.root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initRecyclerView() {
        adapterMain = ParentAdapter()
        binding.recyclerMain.layoutManager = LinearLayoutManager(activity)
        binding.recyclerMain.adapter = adapterMain
    }


}