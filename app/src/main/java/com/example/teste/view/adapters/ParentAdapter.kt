package com.example.teste.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager

import androidx.recyclerview.widget.RecyclerView

import com.example.teste.databinding.RecyclerPrincipalTelaPrincipalBinding
import com.example.teste.view.models.FilmeVO

class ParentAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var childAdapter : ChildAdapter
    var movies = mutableListOf<FilmeVO>()


    fun setMovieList(moviesRecive : List<FilmeVO>){
        this.movies = moviesRecive.toMutableList()
        notifyDataSetChanged()
        childAdapter.setMovieList(moviesRecive)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        childAdapter = ChildAdapter()
        val binding = RecyclerPrincipalTelaPrincipalBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        binding.rvChild.apply { layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = childAdapter
        }
        return MainViewHolder(binding)
        initFragmentResultListener()
    }

    private fun initFragmentResultListener() {

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is MainViewHolder ->{
                holder.bind()
            }
        }
    }

    override fun getItemCount(): Int {
        return 3
    }

     class MainViewHolder(itemView : RecyclerPrincipalTelaPrincipalBinding) : RecyclerView.ViewHolder(itemView.root){
        fun bind(){

        }
        }
    }

