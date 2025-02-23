package com.example.taskbd.data

import com.google.gson.Gson
import retrofit2.http.GET

interface ApiService {
    @GET("Contents.json")
    suspend fun getData(): Gson
}