package com.example.android.marsphotos.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create
import retrofit2.http.GET

private const val BASE_URL =
    "https://android-kotlin-fun-mars-server-.appspot.com"

// Retrofit object
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

// MarsApiService which has methods to communicate with the web server
interface MarsApiService{
    @GET("photos")
    suspend fun getPhotos(): String
}

object MarsApi{
    // Retrofit Service
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}