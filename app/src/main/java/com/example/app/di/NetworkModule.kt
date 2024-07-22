package com.example.app.di

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    private val bodyClientInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(bodyClientInterceptor)
        .callTimeout(300000, TimeUnit.MILLISECONDS) //5 minutes in milliseconds

    companion object {
        var paytefServiceHost: String = "localhost"
    }


    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences(
            "shared_preferences", Context.MODE_PRIVATE
        )
}