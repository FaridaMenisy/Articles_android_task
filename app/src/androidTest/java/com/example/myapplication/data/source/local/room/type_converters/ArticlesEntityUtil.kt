package com.example.myapplication.data.source.local.room.type_converters

import com.example.myapplication.data.source.local.room.ArticlesEntity
import com.example.myapplication.domain.model.ArticleDetials
import com.example.myapplication.domain.model.ArticlesModel

object ArticlesEntityUtil {
    fun getArticlesEntity() =
        ArticlesEntity(
            articlesModel = ArticlesModel(
                status = "Not_Ok",
                num_results = 1,
                articlesDetailsList = MutableList(3) {
                    ArticleDetials(
                        imageUrl = "",
                        url = "",
                        title = "books",
                        section = "arts",
                        published_date = "2020",
                        media = mutableListOf(),
                        des_facet = mutableListOf(),
                        byline = "",
                        abstract = "",
                        source = ""
                    )
                }
            )


        )
}