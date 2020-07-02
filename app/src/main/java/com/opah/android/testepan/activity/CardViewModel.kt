package com.opah.android.testepan.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.opah.android.testepan.model.CardModel
import com.opah.android.testepan.repository.CardRepository

class CardViewModel(val repository: CardRepository) : ViewModel() {

    fun getCardLiveData(type: String, classes: String): LiveData<List<CardModel>> =
        repository.getCollectibleCardsForClass(type, classes)


}


