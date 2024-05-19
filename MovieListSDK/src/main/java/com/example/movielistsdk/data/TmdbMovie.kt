package com.example.movielistsdk.data

import java.io.Serializable

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

data class TmdbMovieDetail(
    val adult: Boolean,
    val backdrop_path: String,
    val belongs_to_collection: BelongToCollection,
    val budget: Double,
    val genres: List<Genres>,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val production_companies: List<ProductionCompanies>,
    val production_countries: List<ProductionCountries>,
    val release_date: String,
    val revenue: Double,
    val runtime: Double,
    val spoken_languages: List<SpokenLanguages>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Long
) : Serializable

data class BelongToCollection (
    val id: Int,
    val name: String,
    val poster_path: String,
    val backdrop_path: String
) : Serializable

data class Genres (
    val id: Int,
    val name: String
) : Serializable

data class ProductionCompanies (
    val id: Int,
    val logo_path: String,
    val name: String,
    val origin_country: String
) : Serializable

data class ProductionCountries (
    val iso_3166_1: String,
    val name: String
) : Serializable

data class SpokenLanguages (
    val english_name: String,
    val iso_639_1: String,
    val name: String
) : Serializable