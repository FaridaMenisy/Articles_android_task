package com.example.myapplication.presentation.details

import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.domain.model.ArticleDetials
import com.example.myapplication.presentation.BaseActivity
import com.example.myapplication.util.Constants
import com.example.myapplication.util.load
import kotlinx.android.synthetic.main.activity_article_details.*

class ArticleDetailsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val articleDetails :ArticleDetials? = intent.extras?.getParcelable(Constants.ARTICLE_DETAILS_DATA)
        initView(articleDetails)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun getContentLayout(): Int = R.layout.activity_article_details

    private fun initView(articleDetails: ArticleDetials?){
        articleDetails?.let {
            setToolBarTitle(it.section)
            tvArticleSource.text = it.source
            tvArticleTitle.text = it.title
            tvArticleDesc.text = it.abstract
            ivArticle.load(it.media[0].metaData[0].url, placeHolder = R.drawable.ic_launcher_background)

        }

    }
}