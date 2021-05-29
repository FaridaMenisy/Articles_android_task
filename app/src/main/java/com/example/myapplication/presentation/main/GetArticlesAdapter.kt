package com.example.myapplication.presentation.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.domain.model.ArticleDetials
import kotlinx.android.synthetic.main.article_card_item.view.*


class GetArticlesAdapter(val onArticleClick: (ArticleDetials) -> Unit) :
    RecyclerView.Adapter<GetArticlesAdapter.ArticlesViewHolder>() {

    private var articlesList = mutableListOf<ArticleDetials>()

    fun setArticlesList(articlesList: MutableList<ArticleDetials>) {
        this.articlesList.clear()
        this.articlesList.addAll(articlesList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        val inflater =
            parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val inflatedView: View = inflater.inflate(R.layout.article_card_item, parent, false)
        return ArticlesViewHolder(inflatedView)
    }

    override fun getItemCount(): Int = articlesList.size

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        holder.bind(articlesList[position])
    }

    inner class ArticlesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(articleDetials: ArticleDetials) {
            with(itemView) {
                articleDetials.apply {
                    tvArticleTitle.text = title
                    tvArticleAuthor.text = byline
                    tvArticleDate.text = published_date
                    cvArticle.setOnClickListener {
                        onArticleClick.invoke(articleDetials)
                    }
                }

            }

        }
    }
}