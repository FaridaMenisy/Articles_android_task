package com.example.myapplication.presentation.main

import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.usecase.GetArticlesUseCase
import javax.inject.Inject


class GetArticlesViewModel @Inject constructor(private var getArticlesUseCase: GetArticlesUseCase) :
    ViewModel() {
    val getArticlesLiveData by lazy { getArticlesUseCase.getArticlesLiveData }

    fun getArticles(sections: String, period: String) {
        getArticlesUseCase.getArticles(sections, period)
    }

    override fun onCleared() {
        super.onCleared()
        getArticlesUseCase.compositeDisposable.clear()
    }

}