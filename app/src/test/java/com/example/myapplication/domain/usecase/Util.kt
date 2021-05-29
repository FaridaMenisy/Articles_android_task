package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.model.ArticleDetials
import com.example.myapplication.domain.model.ArticlesModel

object Util {

    val articleDetailsList = MutableList(2,init = {
        ArticleDetials(
            source = "",
            abstract = "",
            byline = "",
            des_facet = mutableListOf(),
            imageUrl = "",
            media = mutableListOf(),
            published_date = "",
            section = "",
            title = "",
            url = ""

        )
        ArticleDetials(
            source = "",
            abstract = "",
            byline = "",
            des_facet = mutableListOf(),
            imageUrl = "",
            media = mutableListOf(),
            published_date = "",
            section = "",
            title = "",
            url = ""

        )

    })
    fun getArticleDetailsModel() : ArticlesModel =
        ArticlesModel(status = "OK",articlesDetailsList = articleDetailsList, num_results = 2)


}