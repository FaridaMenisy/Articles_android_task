package com.example.myapplication.data.services

import com.example.myapplication.domain.model.ArticlesModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface GetArticlesAPI {
    @GET("svc/mostpopular/v2/mostviewed/{section}/{period}.json")
     fun getArticles(@Path("section") section:String,
                            @Path("period") period:String
                            ) : Single<ArticlesModel>
}