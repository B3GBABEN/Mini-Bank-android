package com.b3g.fawri.minibank.di

import com.b3g.fawri.minibank.data.validation.remote.moels.retrofit.ClientApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {
    @Provides
    @Singleton
    fun provideClientApi(retrofit :Retrofit): ClientApi
    {
        return retrofit.create(ClientApi::class.java)
    }
}