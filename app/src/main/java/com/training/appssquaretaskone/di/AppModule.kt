package com.training.appssquaretaskone.di

import com.training.appssquaretaskone.data.remote.ApiService
import com.training.appssquaretaskone.utils.ApiUtils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun getApiManager():Retrofit{
     return Retrofit
         .Builder()
         .baseUrl(ApiUtils.BASE_URL)
         .addConverterFactory(GsonConverterFactory.create())
         .build()
    }

    @Singleton
    @Provides
    fun getApiService(retrofit: Retrofit):ApiService{
       return retrofit
            .create(ApiService::class.java)
    }
}