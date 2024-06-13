package com.b3g.fawri.minibank.data.repositories

import com.b3g.fawri.minibank.core.utils.errors.DataError
import com.b3g.fawri.minibank.core.utils.errors.RequestResult
import com.b3g.fawri.minibank.core.utils.errors.RootError
import com.b3g.fawri.minibank.data.remote.moels.Account
import com.b3g.fawri.minibank.data.validation.remote.moels.retrofit.ClientApi
import com.b3g.fawri.minibank.domain.repositories.AccountRepository
import javax.inject.Inject

class AccountRepositoryImpl @Inject constructor(
    private val api: ClientApi
) : AccountRepository {
    override suspend fun getAccounts(): RequestResult<List<Account>, RootError> {
        return try {
            val accounts = listOf(
                Account(
                    id = 1,
                    accountNumber = "**** **** **** 1234",
                    balance = "52000.00 MAD",
                    description = "Aima card",
                    amount = "52000.00"
                ),
                Account(
                    id = 2,
                    accountNumber = "**** **** **** 5678",
                    balance = "15000.00 MAD",
                    description = "Aima card",
                    amount = "15000.00"
                ),
                Account(
                    id = 3,
                    accountNumber = "**** **** **** 8978",
                    balance = "1500.00 MAD",
                    description = "aima account",
                    amount = "15000.00"
                )
            )
            RequestResult.Success(accounts)
        } catch (e: Exception) {
            RequestResult.Error(DataError.Network.ACCOUNT_ERROR)
        }
    }}