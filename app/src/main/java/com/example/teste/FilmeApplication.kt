package com.example.teste

import FilmeViewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import android.app.Application
import com.example.teste.view.internet.RetrofitService
import com.example.teste.view.repositories.MovieRepository
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel

class FilmeApplication : Application() {

    val appModule = module {
        viewModel { FilmeViewModel(get()) }
        single { MovieRepository(get()) }
        single { RetrofitService.getInstance() }
    }

    override fun onCreate() {
        super.onCreate()
       startKoin{
           androidContext(this@FilmeApplication)
           modules(appModule)
       }
    }
}