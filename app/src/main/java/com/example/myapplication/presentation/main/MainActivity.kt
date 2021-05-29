package com.example.myapplication.presentation.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.MyApplicationClass
import com.example.myapplication.R
import com.example.myapplication.data.nw.Result
import com.example.myapplication.domain.model.ArticlesModel
import com.example.myapplication.presentation.BaseActivity
import com.example.myapplication.util.Constants
import com.example.myapplication.util.UiManager
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    // You want Dagger to provide an instance of GetArticlesUseCase from the graph
    @Inject
    lateinit var factory: GetArticlesViewModelFactory
    private val getArticlesViewModel: GetArticlesViewModel by lazy {
        ViewModelProvider(
            this,
            factory
        ).get(GetArticlesViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (applicationContext as MyApplicationClass).appComponent.inject(this)

        getArticlesViewModel.getArticles("all-sections", "7")
        setToolBarTitle(getString(R.string.toolbar_title_main))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_actions, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_search -> {
            true
        }
        R.id.action_menu -> {
            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    override fun getContentLayout(): Int = R.layout.activity_main

    override fun onStart() {
        super.onStart()
        initGetArticlesObserver()
    }

    private fun initGetArticlesObserver() {
        val getArticlesObserver = Observer<Result<ArticlesModel>> { articlesModelResponse ->
            when (articlesModelResponse) {
                is Result.Loading -> {
                    showProgress()
                }
                is Result.Success -> {
                    errorGrp.visibility = View.GONE
                    hideProgress()
                    initArticlesAdapter(articlesModelResponse.data)
                }

                is Result.Error -> {
                    hideProgress()
                    handleError()
                }
            }
        }
        getArticlesViewModel.getArticlesLiveData.observe(this, getArticlesObserver)

    }

    private fun initArticlesAdapter(articlesModel: ArticlesModel) {
        with(rvArticles) {
            GetArticlesAdapter(
                //handles on article click action
                onArticleClick = { selectedArticle ->
                    UiManager.startArticleDetailsActivity(this@MainActivity, data = selectedArticle)
                }).apply {
                setArticlesList(articlesModel.articlesDetailsList)
                adapter = this
            }
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }


    private fun handleError() {
        errorGrp.visibility = View.VISIBLE
        btnRefresh.setOnClickListener {
            getArticlesViewModel.getArticles(Constants.ALL_SECTIONS, Constants.MAX_PERIOD)
        }
    }

    private fun showProgress() {
        errorGrp.visibility = View.GONE
        showLoading()
    }

    private fun hideProgress() {
        hideLoading()
    }


}