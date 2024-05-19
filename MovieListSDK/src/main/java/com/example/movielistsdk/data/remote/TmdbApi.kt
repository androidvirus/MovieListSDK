package com.example.movielistsdk.data.remote

import com.example.movielistsdk.data.TmdbMovieDetail
import com.example.movielistsdk.data.TmdbMovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TmdbApi{

    @GET("popular")
    suspend fun getPopularMovie(): Response<TmdbMovieResponse>

    @GET("upcoming")
    suspend fun getUpComingMovie(): Response<TmdbMovieResponse>

    @GET("{movieId}")
    suspend fun getMovieDetails(@Path("movieId") movieId: String): Response<TmdbMovieDetail>
}