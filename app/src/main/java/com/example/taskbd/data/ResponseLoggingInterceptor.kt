package com.example.taskbd.data

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class ResponseLoggingInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())

        val code = response.code
        println("Server Response Code: $code")

        return response
    }
}