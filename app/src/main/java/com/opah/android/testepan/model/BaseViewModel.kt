package com.opah.android.testepan.model

import androidx.lifecycle.ViewModel
import com.opah.android.testepan.repository.Repository

abstract class BaseViewModel(protected val repository: Repository) : ViewModel() {

    override fun onCleared() {
        super.onCleared()
       // repository.onDestroy()
    }
}
