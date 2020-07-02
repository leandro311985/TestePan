package com.opah.android.testepan.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.opah.android.testepan.repository.Repository
import com.opah.android.testepan.model.VersionInfoModel

class MainViewModel(private val repository: Repository) : ViewModel() {


    val infoLiveData: MutableLiveData<VersionInfoModel> = repository.getInfo()


}