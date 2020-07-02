package com.opah.android.testepan.di

import com.opah.android.testepan.repository.CardRepository
import com.opah.android.testepan.repository.Repository
import com.opah.android.testepan.activity.CardViewModel
import com.opah.android.testepan.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModules = module {
    viewModel { CardViewModel(get()) }
    viewModel { MainViewModel(get()) }

}
val repositoryModule = module {
    single { Repository() }
    single { CardRepository() }

}

val appModules = listOf(viewModelModules, repositoryModule)
