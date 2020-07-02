package com.opah.android.testepan.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HearthstoneApi {

     const val BASE_URL = "https://omgvamp-hearthstone-v1.p.rapidapi.com/"

    private var servicesApiInterface: ApiService? = null

    fun build(): ApiService? {
        var builder: Retrofit.Builder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

        var httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
        httpClient.addInterceptor(TokenInterceptor())

        var retrofit: Retrofit = builder.client(httpClient.build()).build()
        servicesApiInterface = retrofit.create(
            ApiService::class.java
        )

        return servicesApiInterface as ApiService
    }

}