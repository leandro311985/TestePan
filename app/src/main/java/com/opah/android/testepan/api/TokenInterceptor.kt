package com.opah.android.testepan.api

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class TokenInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("x-rapidapi-host", "omgvamp-hearthstone-v1.p.rapidapi.com")
            .addHeader(API_KEY, "2e129cac0amshae5fff82a0eaee4p1c4dcajsn10a129d83d5a")
            .build()
        return chain.proceed(request)
    }

    companion object {
        private const val API_KEY = "x-rapidapi-key"
    }
}