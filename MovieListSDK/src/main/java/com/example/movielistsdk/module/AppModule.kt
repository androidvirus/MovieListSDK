package com.example.movielistsdk.module

import com.example.movielistsdk.data.repository.MovieRepository
import com.example.movielistsdk.data.repository.MovieRepositoryData
import com.example.movielistsdk.ui.MovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    factory {  MovieRepositoryData(get()) }
    factory {  MovieRepository(get()) }
    viewModel {
        MovieViewModel(get(), get())
    }
}