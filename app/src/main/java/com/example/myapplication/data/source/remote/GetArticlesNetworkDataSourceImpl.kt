package com.example.myapplication.data.source.remote

import com.example.myapplication.data.nw.ServiceFactory
import com.example.myapplication.data.services.GetArticlesAPI
import com.example.myapplication.domain.model.ArticlesModel
import io.reactivex.Single



class GetArticlesNetworkDataSourceImpl(private var serviceFactory: ServiceFactory)  : GetArticlesNetworkDataSource {
    override fun getArticlesFromNetwork(sections: String, period: String): Single<ArticlesModel> {
      return serviceFactory.buildApi(GetArticlesAPI::class.java).getArticles(sections, period)
    }
}