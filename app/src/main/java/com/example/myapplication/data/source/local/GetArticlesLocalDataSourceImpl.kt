package com.example.myapplication.data.source.local

import com.example.myapplication.data.source.local.room.ArticlesStore
import com.example.myapplication.domain.model.ArticlesModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetArticlesLocalDataSourceImpl @Inject constructor(  private var articlesStore : ArticlesStore) : GetArticlesLocalDataSource {
    override fun getCachedArticles(): ArticlesModel? {
        return articlesStore.getArticles()
    }

    override fun cacheArticles(articlesModel: ArticlesModel) {
       articlesStore.insertArticles(articlesModel = articlesModel)
    }
}