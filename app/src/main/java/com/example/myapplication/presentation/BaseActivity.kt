package com.example.myapplication.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import kotlinx.android.synthetic.main.base_activity.*

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_activity)
        setUpUi()
        setSupportActionBar(my_toolbar)
    }

    private fun setUpUi() {
        contentLayout.addView(layoutInflater.inflate(getContentLayout(), null))
    }

    open fun setToolBarTitle(title: String?) {
        title?.let {
            my_toolbar.title = it
        }

    }

    open fun hideLoading(){
        progress_circular.visibility = View.GONE
    }

    open fun showLoading(){
        progress_circular.visibility = View.VISIBLE
    }
    protected abstract fun getContentLayout(): Int
}