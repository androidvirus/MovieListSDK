package com.example.movielistsdk.data.remote

import android.content.Context
import com.example.movielistsdk.AppConstants.API_INTERNET_MESSAGE
import com.example.movielistsdk.AppConstants.hasInternetConnection
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

inline fun <reified T> toMovieResultFlow(context: Context, crossinline call: suspend () -> Response<T>): Flow<NetWorkResult<T>> {
    return flow {
        val isInternetConnected = hasInternetConnection(context)
        if (isInternetConnected) {
            emit(NetWorkResult.Loading(true))
            try {
                val c = call()
                if (c.isSuccessful && c.body() != null) {
                    emit(NetWorkResult.Success(c.body()))
                } else {
                    emit(NetWorkResult.Error(c.message()))
                }
            } catch (e: Exception) {
                emit(NetWorkResult.Error(e.toString()))
            }
        } else {
            emit(NetWorkResult.Error(API_INTERNET_MESSAGE))
        }
    }.flowOn(Dispatchers.IO)
}