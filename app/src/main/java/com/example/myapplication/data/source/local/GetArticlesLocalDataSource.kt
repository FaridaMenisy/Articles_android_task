package com.example.myapplication.data.source.local

import com.example.myapplication.domain.model.ArticlesModel


interface GetArticlesLocalDataSource {
    fun getCachedArticles(): ArticlesModel?
    fun cacheArticles(articlesModel: ArticlesModel)
}