package com.example.myapplication.data.source.local.room.type_converters

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myapplication.data.source.local.room.AppDatabase
import com.example.myapplication.data.source.local.room.ArticlesDao
import junit.framework.TestCase
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith



@RunWith(AndroidJUnit4::class)
class AppDatabaseTest : TestCase() {

    private lateinit var db: AppDatabase
    private lateinit var dao: ArticlesDao


    // Override function setUp() and annotate it with @Before
    // this function will be called at first when this test class is called
    @Before
    public override fun setUp() {
        // get context -- since this is an instrumental test it requires
        // context from the running application
        val context = ApplicationProvider.getApplicationContext<Context>()
        // initialize the db and dao variable
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        dao = db.getArticlesDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun insertAndGetArticles() {
        // Given
        val articlesEntity = ArticlesEntityUtil.getArticlesEntity()
        // When
        dao.insertArticles(articlesEntity)
        val articlesModel = dao.getArticles()
        // Then
        Assert.assertEquals(articlesModel.articlesModel?.status, "Not_Ok" )
    }
}