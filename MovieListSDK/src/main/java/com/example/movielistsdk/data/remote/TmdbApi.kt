package com.example.movielistsdk.data.remote

import com.example.movielistsdk.data.TmdbMovieResponse
import retrofit2.Response
import retrofit2.http.GET

interface TmdbApi{

    @GET("popular")
    suspend fun getPopularMovie(): Response<TmdbMovieResponse>
}