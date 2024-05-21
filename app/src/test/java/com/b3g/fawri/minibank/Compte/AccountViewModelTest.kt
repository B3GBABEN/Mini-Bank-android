package com.b3g.fawri.minibank.Compte

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.b3g.fawri.minibank.ui.Comptes.AccountViewModel
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.Before
import org.mockito.Mock
import org.mockito.MockitoAnnotations


class AccountViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: AccountViewModel

    @Mock
    private lateinit var balanceObserver: Observer<Double>

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        viewModel = AccountViewModel()
    }

    @Test
    fun testUpdateBalance() {
        val expectedBalance = 100.0

        viewModel.accountBalance.observeForever(balanceObserver)
        viewModel.updateBalance(expectedBalance)

        assertEquals(expectedBalance, viewModel.accountBalance.value)
    }
}
