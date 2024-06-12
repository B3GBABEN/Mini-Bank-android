package com.b3g.fawri.minibank.activities.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.b3g.fawri.minibank.api.models.Transaction
import com.b3g.fawri.minibank.presentation.screens.home.transactions.TransactionItem
import com.b3g.fawri.minibank.presentation.screens.home.HomeViewModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var viewModel: HomeViewModel

    @Before
    fun setUp() {
        viewModel = HomeViewModel()
    }

    @Test
    fun testGroupTransactionsByDate() {
        val transactions = listOf(
            Transaction(date = "Aujourd'hui", description = "Virement de Mr EL ALAOUI", amount = 500.0, accountId = 1),
            Transaction(date = "Aujourd'hui", description = "paiment ...", amount = -500.0, accountId = 1),
            Transaction(date = "Hier", description = "paiment ...", amount = -500.0, accountId = 1),
            Transaction(date = "Hier", description = "Virement de Mme EL ALAOUI", amount = 500.0, accountId = 1)
        )

        val expected = listOf(
            TransactionItem.DateHeader("Aujourd'hui"),
            TransactionItem.TransactionDetail(Transaction(date = "Aujourd'hui", description = "Virement de Mr EL ALAOUI", amount = 500.0, accountId = 1)),
            TransactionItem.TransactionDetail(Transaction(date = "Aujourd'hui", description = "paiment ...", amount = -500.0, accountId = 1)),
            TransactionItem.DateHeader("Hier"),
            TransactionItem.TransactionDetail(Transaction(date = "Hier", description = "paiment ...", amount = -500.0, accountId = 1)),
            TransactionItem.TransactionDetail(Transaction(date = "Hier", description = "Virement de Mme EL ALAOUI", amount = 500.0, accountId = 1))
        )

        val result = viewModel.groupTransactionsByDate(transactions)

        assertEquals(expected, result)
    }
}
