package com.example.myapplication.data.source

import com.example.myapplication.data.source.local.GetArticlesLocalDataSource
import com.example.myapplication.data.source.remote.GetArticlesNetworkDataSource
import com.example.myapplication.domain.model.ArticlesModel
import com.example.myapplication.domain.repository.GetArticlesRepo
import io.reactivex.Single


class GetArticlesRepoImpl constructor(
    private var getArticlesNetworkDataSource: GetArticlesNetworkDataSource,
    private var getArticlesLocalDataSource: GetArticlesLocalDataSource
) : GetArticlesRepo {
    override fun getArticles(sections: String, period: String): Single<ArticlesModel> {
        return getArticlesNetworkDataSource.getArticlesFromNetwork(sections, period).doOnSuccess {
            getArticlesLocalDataSource.cacheArticles(it)
        }.doOnError {
            getArticlesLocalDataSource.getCachedArticles()
        }

    }

    override fun getCachedArticles(): Single<ArticlesModel> {
        getArticlesLocalDataSource.getCachedArticles()?.let {
            return Single.just(it)
        } ?: return Single.error(Throwable())
    }
}