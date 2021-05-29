package com.example.myapplication

import android.app.Application
import com.example.myapplication.data.source.local.room.ArticlesStore
import com.example.myapplication.di.AppModule
import com.example.myapplication.di.NetworkModule
import com.example.myapplication.presentation.main.MainActivity
import dagger.Component
import javax.inject.Singleton



@Singleton
@Component(modules = [NetworkModule::class, AppModule::class])
interface ApplicationComponent {
    fun inject(activity: MainActivity)
    fun inject(articlesStore: ArticlesStore)
}

// appComponent lives in the Application class to share its lifecycle
class MyApplicationClass : Application() {
    // Reference to the application graph that is used across the whole app
     val appComponent = DaggerApplicationComponent.builder()
        .appModule(AppModule(this))
        .build()


}

