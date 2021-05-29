package com.example.myapplication.domain.repository

import com.example.myapplication.domain.model.ArticlesModel
import io.reactivex.Single

interface GetArticlesRepo {
    fun getArticles(sections:String, period:String) : Single<ArticlesModel>
    fun getCachedArticles() :Single<ArticlesModel>
}