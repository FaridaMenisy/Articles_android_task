package com.example.myapplication.util

import android.content.Context
import android.content.Intent
import com.example.myapplication.domain.model.ArticleDetials
import com.example.myapplication.presentation.details.ArticleDetailsActivity
import com.example.myapplication.util.Constants.ARTICLE_DETAILS_DATA

object UiManager {

    fun startArticleDetailsActivity(context: Context, data: ArticleDetials) {
        val intent = Intent(context, ArticleDetailsActivity::class.java)
        intent.putExtra(ARTICLE_DETAILS_DATA, data)
        context.startActivity(intent)
    }
}