package com.example.myapplication.data.source.local.room

import android.content.Context
import androidx.room.*
import com.example.myapplication.data.source.local.room.type_converters.ArticlesTypeConverter


@Database(entities = [ArticlesEntity::class], version = 1, exportSchema = false)
@TypeConverters(ArticlesTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getArticlesDao(): ArticlesDao
    companion object {
        private var db_instance: AppDatabase? = null
        fun getDatabaseInstance(context: Context): AppDatabase {
            db_instance?.let {
                return it
            } ?: return Room.databaseBuilder(
                context.applicationContext, AppDatabase::class.java, "app_db"
            ).build()


        }
    }
}