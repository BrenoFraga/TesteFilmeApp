package com.example.teste.view.viewModels

import FilmeViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.teste.view.repositories.MovieRepository

class MyViewModelFactory(private val repository: MovieRepository):
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(FilmeViewModel::class.java)) {
            FilmeViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}
