package com.b3g.fawri.minibank.data.repositories

import com.b3g.fawri.minibank.core.utils.errors.DataError
import com.b3g.fawri.minibank.core.utils.errors.RequestResult
import com.b3g.fawri.minibank.core.utils.errors.RootError
import com.b3g.fawri.minibank.data.remote.moels.Account
import com.b3g.fawri.minibank.data.remote.moels.Transaction
import com.b3g.fawri.minibank.data.validation.remote.moels.retrofit.ClientApi
import com.b3g.fawri.minibank.domain.repositories.TransactionRepository
import javax.inject.Inject

class TransactionRepositoryImpl @Inject constructor(
    private val api: ClientApi
) : TransactionRepository {
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


}