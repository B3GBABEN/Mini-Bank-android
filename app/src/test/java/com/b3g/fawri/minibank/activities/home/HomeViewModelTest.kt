package com.b3g.fawri.minibank.activities.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.b3g.fawri.minibank.core.utils.errors.DataError
import com.b3g.fawri.minibank.core.utils.errors.RequestResult
import com.b3g.fawri.minibank.core.utils.errors.RootError
import com.b3g.fawri.minibank.data.remote.moels.Account
import com.b3g.fawri.minibank.data.remote.moels.SponsoringCard
import com.b3g.fawri.minibank.data.remote.moels.Transaction
import com.b3g.fawri.minibank.domain.usecases.GetAccountsUseCase
import com.b3g.fawri.minibank.domain.usecases.GetSponsoringCardsUseCase
import com.b3g.fawri.minibank.domain.usecases.GetTransactionsUseCase
import com.b3g.fawri.minibank.presentation.screens.home.HomeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var viewModel: HomeViewModel
    private lateinit var homeRepository: MockHomeRepository

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        homeRepository = MockHomeRepository()
        viewModel = HomeViewModel(
            GetAccountsUseCase(homeRepository),
            GetSponsoringCardsUseCase(homeRepository),
            GetTransactionsUseCase(homeRepository)
        )
    }
    @Test
    fun `fetchAccounts updates state with accounts`() = runTest {
        viewModel.state.value.accounts?.let {
            Assert.assertEquals(MockHomeRepository.accounts, it)
        }
    }
    @Test
    fun `fetchSponsoringCards updates state with sponsoring cards`() = runTest {
        viewModel.state.value.sponsoringCards?.let {
            Assert.assertEquals(MockHomeRepository.sponsoringCards, it)
        }
    }
}

class MockHomeRepository : HomeRepository {
    var shouldReturnError = false

    companion object {
        val accounts = listOf(
            Account(id = 1, accountNumber = "**** **** **** 1234", balance = "52000.00 MAD", description = "Aima card", amount = "52000.00"),
            Account(id = 2, accountNumber = "**** **** **** 5678", balance = "15000.00 MAD", description = "Aima card", amount = "15000.00"),
            Account(id = 3, accountNumber = "**** **** **** 8978", balance = "1500.00 MAD", description = "aima account", amount = "15000.00")
        )

        val transactions = listOf(
            Transaction(date = "Aujourd'hui", description = "Virement de Mr EL ALAOUI", amount = 500.0, accountId = 1),
            Transaction(date = "Aujourd'hui", description = "paiment ...", amount = -500.0, accountId = 1),
            Transaction(date = "Hier", description = "paiment ...", amount = -500.0, accountId = 1),
            Transaction(date = "Hier", description = "Virement de Mme EL ALAOUI", amount = 500.0, accountId = 1)
        )

        val sponsoringCards = listOf(
            SponsoringCard(id = 1, imageResId = 0),
            SponsoringCard(id = 2, imageResId = 0),
            SponsoringCard(id = 3, imageResId = 0)
        )
    }

    override suspend fun getAccounts(): RequestResult<List<Account>, RootError> {
        return if (shouldReturnError) {
            RequestResult.Error(DataError.Network.ACCOUNT_ERROR)
        } else {
            RequestResult.Success(accounts)
        }
    }

    override suspend fun getTransactions(): RequestResult<List<Transaction>, RootError> {
        return if (shouldReturnError) {
            RequestResult.Error(DataError.Network.TRANSACTION_ERROR)
        } else {
            RequestResult.Success(transactions)
        }
    }

    override suspend fun getSponsoringCards(): RequestResult<List<SponsoringCard>, RootError> {
        return if (shouldReturnError) {
            RequestResult.Error(DataError.Network.SPONSOR_ERROR)
        } else {
            RequestResult.Success(sponsoringCards)
        }
    }
}
