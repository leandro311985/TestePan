package com.opah.android.testepan.api

import com.opah.android.testepan.model.CardModel
import com.opah.android.testepan.model.VersionInfoModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("info")
    fun getVersionInfo(): Call<VersionInfoModel>

    @GET("cards/{type}/{class}")
    fun getCollectibleCardsForClass(
        @Path("type") type: String,
        @Path("class") className: String
    ): Call<List<CardModel>>

}
