package com.example.myapplication.di

import com.example.myapplication.data.nw.RetrofitServiceFactory
import com.example.myapplication.data.nw.ServiceFactory
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class NetworkModule {

    private fun provideLoggingInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }


    private fun providesQueryParamInterceptor(): Interceptor {
        return Interceptor { chain ->
            val original = chain.request()
            val originalHttpUrl = original.url
            val url = originalHttpUrl.newBuilder()
                .addQueryParameter("api-key", "BohKNL9zqSsKNcNAy4XrWhBQ4iOZIHen")
                .build()
            val requestBuilder = original.newBuilder()
                .url(url)
            val request = requestBuilder.build()
            chain.proceed(request)

        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
    ): OkHttpClient {
        val builder: OkHttpClient.Builder = OkHttpClient.Builder()
        builder.addInterceptor(providesQueryParamInterceptor())
        builder.addInterceptor(provideLoggingInterceptor())
        return builder
            .connectTimeout(40, TimeUnit.SECONDS)
            .readTimeout(40, TimeUnit.SECONDS)
            .writeTimeout(40, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitServiceFactory(): ServiceFactory =
        RetrofitServiceFactory(
            provideOkHttpClient()
        )
}