package com.example.myapplication.data.source.local.room.type_converters

import androidx.room.TypeConverter
import com.example.myapplication.domain.model.ArticlesModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ArticlesTypeConverter {
    @TypeConverter
    fun fromString(value: String?): ArticlesModel? {
        val type = object : TypeToken<ArticlesModel?>() {}.type
        return Gson().fromJson<ArticlesModel>(value, type)
    }


    @TypeConverter
    fun fromArticlesEntity(articlesModel: ArticlesModel?): String? {
        val gson = Gson()
        return gson.toJson(articlesModel)
    }
}