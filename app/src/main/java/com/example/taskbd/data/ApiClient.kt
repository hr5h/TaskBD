package com.example.taskbd.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL = "https://raw.githubusercontent.com/hr5h/StoryKit/b83399a7c0d83891c53d01bcb70c270123570801/iosApp/iosApp/Assets.xcassets/"

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(ResponseLoggingInterceptor())
        .build()

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}