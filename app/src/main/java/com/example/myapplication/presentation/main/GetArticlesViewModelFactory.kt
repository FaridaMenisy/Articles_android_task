package com.example.myapplication.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.domain.usecase.GetArticlesUseCase



@Suppress("UNCHECKED_CAST")
class GetArticlesViewModelFactory(private var articlesUseCase: GetArticlesUseCase)  : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GetArticlesViewModel::class.java)) {
            return GetArticlesViewModel(articlesUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}