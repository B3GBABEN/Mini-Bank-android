package com.b3g.fawri.minibank.data.repositories

import com.b3g.fawri.minibank.R
import com.b3g.fawri.minibank.core.utils.errors.DataError
import com.b3g.fawri.minibank.core.utils.errors.RequestResult
import com.b3g.fawri.minibank.core.utils.errors.RootError
import com.b3g.fawri.minibank.data.remote.moels.Account
import com.b3g.fawri.minibank.data.remote.moels.SponsoringCard
import com.b3g.fawri.minibank.data.remote.moels.Transaction
import com.b3g.fawri.minibank.data.validation.remote.moels.retrofit.ClientApi
import com.b3g.fawri.minibank.domain.repositories.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val api: ClientApi
) : HomeRepository {
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
    }

    override suspend fun getTransactions(): RequestResult<List<Transaction>, RootError> {
        return try {
            val transactions = listOf(
                Transaction(
                    date = "Aujourd'hui",
                    description = "Virement de Mr EL ALAOUI",
                    amount = 500.0,
                    accountId = 1
                ),
                Transaction(
                    date = "Aujourd'hui",
                    description = "paiment ...",
                    amount = -500.0,
                    accountId = 1
                ),
                Transaction(
                    date = "Hier",
                    description = "paiment ...",
                    amount = -500.0,
                    accountId = 1
                ),
                Transaction(
                    date = "Hier",
                    description = "Virement de Mme EL ALAOUI",
                    amount = 500.0,
                    accountId = 1
                )
            )
            RequestResult.Success(transactions)
        } catch (e: Exception) {
            RequestResult.Error(DataError.Network.TRANSACTION_ERROR)
        }
    }


    override suspend fun getSponsoringCards(): RequestResult<List<SponsoringCard>, RootError> {
        return try {
            val sponsoringCards = listOf(
                SponsoringCard(id = 1, imageResId = R.drawable.card_image),
                SponsoringCard(id = 2, imageResId = R.drawable.card_image),
                SponsoringCard(id = 3, imageResId = R.drawable.card_image)
            )
            RequestResult.Success(sponsoringCards)
        } catch (e: Exception) {
            RequestResult.Error(DataError.Network.SPONSOR_ERROR)
        }

    }
}

