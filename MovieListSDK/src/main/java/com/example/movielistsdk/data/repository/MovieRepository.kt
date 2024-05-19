package com.example.movielistsdk.data.repository

import android.content.Context
import com.example.movielistsdk.data.TmdbMovieResponse
import com.example.movielistsdk.data.remote.toMovieResultFlow
import com.example.movielistsdk.data.remote.NetWorkResult
import kotlinx.coroutines.flow.Flow

class MovieRepository(private val movieRepositoryData: MovieRepositoryData) {

    suspend fun getPopularMovieList(context: Context): Flow<NetWorkResult<TmdbMovieResponse>> {
        return toMovieResultFlow(context) {
            movieRepositoryData.getPopularMovie()
        }
    }

    suspend fun getUpComingMovieList(context: Context): Flow<NetWorkResult<TmdbMovieResponse>> {
        return toMovieResultFlow(context) {
            movieRepositoryData.getUpComingMovie()
        }
    }
}