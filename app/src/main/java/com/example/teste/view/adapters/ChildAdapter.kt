package com.example.teste.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.teste.databinding.ChildLayoutBinding
import com.example.teste.view.models.FilmeVO

class ChildAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var movies = mutableListOf<FilmeVO>()

    fun setMovieList(moviesRecive : List<FilmeVO>){
        this.movies = moviesRecive.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        return ChildViewHolder(ChildLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val movie = movies[position]
        when(holder){
            is ChildViewHolder ->{
                holder.bind(movie)
            }
        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    inner class ChildViewHolder(itemView: ChildLayoutBinding) : RecyclerView.ViewHolder(itemView.root){
        private val img = itemView.imgCvChild
        fun bind(filme : FilmeVO){
            Glide.with(itemView)
                .load(filme.poster_path)
                .into(img)
        }
    }
}