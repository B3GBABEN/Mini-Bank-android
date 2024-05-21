package com.b3g.fawri.minibank.di

import com.b3g.fawri.minibank.data.repositories.LoginRepositoryImpl
import com.b3g.fawri.minibank.data.validation.remote.moels.retrofit.ClientApi
import com.b3g.fawri.minibank.domain.repositories.LoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoriesModule {
    @Provides
    @Singleton
    fun provideLoginRepository(clientApi : ClientApi) : LoginRepository
    {
        return LoginRepositoryImpl(clientApi)
    }
}