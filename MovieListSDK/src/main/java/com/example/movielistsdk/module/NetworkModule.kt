package com.example.movielistsdk.module

import com.example.movielistsdk.AppConstants
import com.example.movielistsdk.data.remote.TmdbApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun authInterceptor(): Interceptor {
    return Interceptor { chain ->
        val newUrl = chain.request().url
            .newBuilder()
            .addQueryParameter("api_key", AppConstants.Tmdb_Api_Key)
            .build()

        val newRequest = chain.request()
            .newBuilder()
            .url(newUrl)
            .build()

        chain.proceed(newRequest)
    }
}

fun loginInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
}

fun clientOkHttp(
    authInterceptor: Interceptor,
    httpLoggingInterceptor: HttpLoggingInterceptor
): OkHttpClient {
    return OkHttpClient().newBuilder()
        .addInterceptor(authInterceptor)
        .addInterceptor(httpLoggingInterceptor)
        .build()
}

fun provideConverterFactory(): GsonConverterFactory =
    GsonConverterFactory.create()

fun retrofit(
    okHttpClient: OkHttpClient,
    gsonConverterFactory: GsonConverterFactory
): Retrofit = Retrofit.Builder()
    .client(okHttpClient)
    .baseUrl(AppConstants.TMDB_BASE_URL)
    .addConverterFactory(gsonConverterFactory)
    .build()

fun provideService(retrofit: Retrofit): TmdbApi =
    retrofit.create(TmdbApi::class.java)

val networkModule = module {
    single { authInterceptor() }
    single { loginInterceptor() }
    single { clientOkHttp(get(), get()) }
    single { provideConverterFactory() }
    single { retrofit(get(), get()) }
    single { provideService(get()) }
}