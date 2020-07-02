package com.opah.android.testepan.repository

import androidx.lifecycle.MutableLiveData
import com.opah.android.testepan.api.HearthstoneApi
import com.opah.android.testepan.model.CardModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CardRepository {

    fun getCollectibleCardsForClass(
        type: String,
        classes: String
    ): MutableLiveData<List<CardModel>> {
        val data = MutableLiveData<List<CardModel>>()
        val repos = HearthstoneApi
        repos.build()?.getCollectibleCardsForClass(type, classes)?.enqueue(object :
            Callback<List<CardModel>> {
            override fun onResponse(
                call: Call<List<CardModel>>,
                response: Response<List<CardModel>>
            ) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<List<CardModel>>, t: Throwable) {
                t.printStackTrace()
            }
        })
        return data
    }

}