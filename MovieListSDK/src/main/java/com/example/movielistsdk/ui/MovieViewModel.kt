package com.example.movielistsdk.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.movielistsdk.data.TmdbMovieResponse
import com.example.movielistsdk.data.remote.NetWorkResult
import com.example.movielistsdk.data.repository.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieViewModel(private val movieRepository: MovieRepository, application: Application) :
    AndroidViewModel(application) {

    private val context
        get() = getApplication<Application>()

    private val _popularMovieState: MutableStateFlow<NetWorkResult<TmdbMovieResponse>> = MutableStateFlow(
        NetWorkResult.Loading(true)
    )
    val popularMovieState: StateFlow<NetWorkResult<TmdbMovieResponse>> = _popularMovieState

    private val _upcomingMovieState: MutableStateFlow<NetWorkResult<TmdbMovieResponse>> = MutableStateFlow(
        NetWorkResult.Loading(true)
    )
    val upcomingMovieState: StateFlow<NetWorkResult<TmdbMovieResponse>> = _upcomingMovieState

    fun getPopularMovieList() {
        viewModelScope.launch {
            movieRepository.getPopularMovieList(context).collect {
                _popularMovieState.value = it
            }
        }
    }

    fun getUpComingMovieList() {
        viewModelScope.launch {
            movieRepository.getUpComingMovieList(context).collect {
                _upcomingMovieState.value = it
            }
        }
    }
}