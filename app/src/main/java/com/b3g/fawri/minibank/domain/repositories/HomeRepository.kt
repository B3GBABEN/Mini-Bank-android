package com.b3g.fawri.minibank.domain.repositories

import com.b3g.fawri.minibank.core.utils.errors.RequestResult
import com.b3g.fawri.minibank.core.utils.errors.RootError
import com.b3g.fawri.minibank.data.remote.moels.Account
import com.b3g.fawri.minibank.data.remote.moels.SponsoringCard
import com.b3g.fawri.minibank.data.remote.moels.Transaction

interface HomeRepository {
    suspend fun getAccounts(): RequestResult<List<Account>, RootError>
    suspend fun getTransactions(): RequestResult<List<Transaction>, RootError>
    suspend fun getSponsoringCards(): RequestResult<List<SponsoringCard>, RootError>
}
