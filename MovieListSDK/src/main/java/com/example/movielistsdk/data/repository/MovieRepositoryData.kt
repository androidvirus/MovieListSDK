package com.example.movielistsdk.data.repository

import com.example.movielistsdk.data.remote.TmdbApi

class MovieRepositoryData(private val api: TmdbApi) {
    suspend fun getPopularMovie() = api.getPopularMovie()
}