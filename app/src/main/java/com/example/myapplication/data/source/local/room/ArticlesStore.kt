package com.example.myapplication.data.source.local.room


import com.example.myapplication.domain.model.ArticlesModel


class ArticlesStore(var appDatabase: AppDatabase) {
    fun insertArticles(articlesModel: ArticlesModel) {
        appDatabase.getArticlesDao().insertArticles(
            ArticlesEntity(
                articlesModel = articlesModel
            )
        )
    }

    fun getArticles(): ArticlesModel? {
        return appDatabase.getArticlesDao().getArticles().articlesModel
    }

//    fun deleteArticles() {
//        appDatabase.getArticlesDao().deleteArticles()
//    }
}