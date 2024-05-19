package com.example.movielistsdk

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

object AppConstants {
    const val TMDB_BASE_URL = "https://api.themoviedb.org/3/movie/"
    const val TMDB_PHOTO_URL = "https://image.tmdb.org/t/p/w500"
    var Tmdb_Api_Key = "909594533c98883408adef5d56143539"

    const val API_INTERNET_MESSAGE = "No Internet Connection"

    fun hasInternetConnection(context: Context?): Boolean {
        try {
            if (context == null)
                return false
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE)
                    as ConnectivityManager
            val activeNetwork = connectivityManager.activeNetwork ?: return false
            val networkCapabilities =
                connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
            return when {
                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        } catch (e: Exception) {
            return false
        }
    }
}