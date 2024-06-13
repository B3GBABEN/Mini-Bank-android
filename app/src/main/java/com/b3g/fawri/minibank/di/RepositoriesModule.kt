package com.b3g.fawri.minibank.di

import com.b3g.fawri.minibank.data.repositories.AccountRepositoryImpl
import com.b3g.fawri.minibank.data.repositories.FactureRepositoryImpl
import com.b3g.fawri.minibank.data.repositories.LoginRepositoryImpl
import com.b3g.fawri.minibank.data.repositories.SponsorRepositoryImpl
import com.b3g.fawri.minibank.data.repositories.TransactionRepositoryImpl
import com.b3g.fawri.minibank.data.validation.remote.moels.retrofit.ClientApi
import com.b3g.fawri.minibank.domain.repositories.AccountRepository
import com.b3g.fawri.minibank.domain.repositories.FactureRepository
import com.b3g.fawri.minibank.domain.repositories.LoginRepository
import com.b3g.fawri.minibank.domain.repositories.SponsorRepository
import com.b3g.fawri.minibank.domain.repositories.TransactionRepository
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

    @Provides
    @Singleton
    fun provideAccountRepository(clientApi : ClientApi) : AccountRepository
    {
        return AccountRepositoryImpl(clientApi)
    }
    @Provides
    @Singleton
    fun provideTransactionRepository(clientApi : ClientApi) : TransactionRepository
    {
        return TransactionRepositoryImpl(clientApi)
    }
    @Provides
    @Singleton
    fun provideSponsorRepository(clientApi : ClientApi) : SponsorRepository
    {
        return SponsorRepositoryImpl(clientApi)
    }
    @Provides
    @Singleton
    fun provideFactureRepository(clientApi : ClientApi) : FactureRepository
    {
        return FactureRepositoryImpl(clientApi)
    }

}