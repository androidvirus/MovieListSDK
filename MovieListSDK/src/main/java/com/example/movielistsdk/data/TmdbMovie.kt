package com.example.movielistsdk.data

data class TmdbMovie(
    val id: Int,
    val vote_average: Double,
    val title: String,
    val original_title: String,
    val overview: String,
    val adult: Boolean,
    val poster_path: String,
    val release_date: String,
    val popularity: String,
    val backdrop_path: String
)

data class TmdbMovieResponse(
    val results: List<TmdbMovie>
)