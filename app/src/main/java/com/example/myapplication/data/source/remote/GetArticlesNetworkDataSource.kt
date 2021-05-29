package com.example.myapplication.data.source.remote

import com.example.myapplication.domain.model.ArticlesModel
import io.reactivex.Single

interface GetArticlesNetworkDataSource {
    fun getArticlesFromNetwork (sections :String, period:String) :Single<ArticlesModel>
}