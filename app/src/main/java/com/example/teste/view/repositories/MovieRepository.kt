package com.example.teste.view.repositories

import com.example.teste.view.internet.RetrofitService
import org.koin.dsl.module

class MovieRepository (private val retrofitService: RetrofitService) {

    fun getAllMovies() = retrofitService.getAllMovies("eab0fdc30dffb44286cc9348afce2be6")

    val repositoryModule = module {
        single { MovieRepository(get()) }
    }
}