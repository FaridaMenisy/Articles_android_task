package com.example.myapplication.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ArticlesModel(
    var status: String,
    @SerializedName("results") var articlesDetailsList: MutableList<ArticleDetials>,
    var num_results: Int
) : Parcelable

@Parcelize
data class ArticleDetials(
    @SerializedName("uri") var imageUrl: String,
    var url: String,
    var source: String,
    var byline: String,
    var title: String,
    var abstract: String,
    var section :String,
    var des_facet: MutableList<String>,
    var media: MutableList<MediaData>,
    var published_date: String
) : Parcelable

@Parcelize
data class MediaData(
    var type: String,
    var caption: String,
    var copyright: String,
    @SerializedName("media-metadata") var metaData: MutableList<MetaData>
) : Parcelable

@Parcelize
data class MetaData(var url :String) :Parcelable