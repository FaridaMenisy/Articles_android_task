package com.example.myapplication.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface ArticlesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticles(articles: ArticlesEntity)

    @Query("Select * From ArticlesEntity")
    fun getArticles(): ArticlesEntity

    @Query("DELETE FROM ArticlesEntity")
    fun deleteArticles ()

}