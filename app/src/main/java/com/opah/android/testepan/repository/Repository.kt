package com.opah.android.testepan.repository

import androidx.lifecycle.MutableLiveData
import com.opah.android.testepan.api.HearthstoneApi
import com.opah.android.testepan.model.VersionInfoModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    fun getInfo(): MutableLiveData<VersionInfoModel> {
        val data = MutableLiveData<VersionInfoModel>()
        val repos = HearthstoneApi
        repos.build()?.getVersionInfo()?.enqueue(object : Callback<VersionInfoModel> {
            override fun onResponse(
                call: Call<VersionInfoModel>,
                response: Response<VersionInfoModel>
            ) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<VersionInfoModel>, t: Throwable) {
                t.printStackTrace()
            }
        })
        return data
    }


}