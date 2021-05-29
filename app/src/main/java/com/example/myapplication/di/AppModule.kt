package com.example.myapplication.di


import android.app.Application
import android.content.Context
import com.example.myapplication.data.nw.ServiceFactory
import com.example.myapplication.data.source.GetArticlesRepoImpl
import com.example.myapplication.data.source.local.GetArticlesLocalDataSource
import com.example.myapplication.data.source.local.GetArticlesLocalDataSourceImpl
import com.example.myapplication.data.source.local.room.AppDatabase
import com.example.myapplication.data.source.local.room.ArticlesDao
import com.example.myapplication.data.source.local.room.ArticlesStore
import com.example.myapplication.data.source.remote.GetArticlesNetworkDataSource
import com.example.myapplication.data.source.remote.GetArticlesNetworkDataSourceImpl

import com.example.myapplication.domain.repository.GetArticlesRepo
import com.example.myapplication.domain.usecase.GetArticlesUseCase
import com.example.myapplication.presentation.main.GetArticlesViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(private var application: Application) {

    @Provides
    @Singleton
    fun provideArticlesRepo(
        getArticlesNetworkDataSource: GetArticlesNetworkDataSource
    ): GetArticlesRepo =
        GetArticlesRepoImpl(getArticlesNetworkDataSource, provideLocalDataSource())

    @Provides
    @Singleton
    fun provideNetworkDataSource(
        serviceFactory: ServiceFactory
    ): GetArticlesNetworkDataSource =
        GetArticlesNetworkDataSourceImpl(serviceFactory)


    @Provides
    fun providesMainViewModelFactory(getArticlesUseCase: GetArticlesUseCase): GetArticlesViewModelFactory {
        return GetArticlesViewModelFactory(getArticlesUseCase)
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(): GetArticlesLocalDataSource = GetArticlesLocalDataSourceImpl(
        provideDatabaseStore()
    )

    @Singleton
    @Provides
    fun provideDatabaseInstance(): AppDatabase = AppDatabase.getDatabaseInstance(provideContext())

    @Singleton
    @Provides
    fun provideContext(): Context = application.applicationContext

    @Singleton
    @Provides
    fun getArticlesDao(appDatabase: AppDatabase): ArticlesDao = appDatabase.getArticlesDao()

    @Singleton
    @Provides
    fun provideDatabaseStore(): ArticlesStore =
        ArticlesStore(
            appDatabase = provideDatabaseInstance()
        )
}