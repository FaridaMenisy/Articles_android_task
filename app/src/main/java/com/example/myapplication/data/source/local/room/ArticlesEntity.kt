package com.example.myapplication.data.source.local.room

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.myapplication.data.source.local.room.type_converters.ArticlesTypeConverter
import com.example.myapplication.domain.model.ArticlesModel

@Entity
data class ArticlesEntity (
    @PrimaryKey(autoGenerate = true)
    @NonNull
    var id: Int = 0,
    @TypeConverters(ArticlesTypeConverter::class)
    @ColumnInfo(name ="articlesData")
    var articlesModel: ArticlesModel ?=null
)
