package com.b3g.fawri.minibank.presentation.screens.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.b3g.fawri.minibank.core.utils.errors.RequestResult
import com.b3g.fawri.minibank.core.utils.errors.RootError
import com.b3g.fawri.minibank.data.remote.moels.Account
import com.b3g.fawri.minibank.data.remote.moels.SponsoringCard
import com.b3g.fawri.minibank.data.remote.moels.Transaction
import com.b3g.fawri.minibank.domain.usecases.GetAccountsUseCase
import com.b3g.fawri.minibank.domain.usecases.GetSponsoringCardsUseCase
import com.b3g.fawri.minibank.domain.usecases.GetTransactionsUseCase
import com.b3g.fawri.minibank.presentation.screens.home.transactions.TransactionItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAccountsUseCase: GetAccountsUseCase,
    private val getSponsoringCardsUseCase: GetSponsoringCardsUseCase,
    private val getTransactionsUseCase: GetTransactionsUseCase
) : ViewModel() {

    data class HomeViewModelState(
        val accounts: List<Account>? = null,
        val sponsoringCards: List<SponsoringCard>? = null,
        val transactions: List<TransactionItem>? = null,
        val error: RootError? = null
    )

    private val _state = MutableStateFlow(HomeViewModelState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            launch {  fetchAccounts() }
            launch {  fetchSponsoringCards() }
            launch {  fetchTransactions() }
        }
    }

    fun fetchAccounts() {
        viewModelScope.launch {
            when (val result = getAccountsUseCase()) {
                is RequestResult.Success -> {
                    _state.value = HomeViewModelState()
                    _state.value = HomeViewModelState(accounts = result.data)

                }
                is RequestResult.Error -> showErrorWith(result.error)
                else -> {}
            }
        }
    }

    fun fetchTransactions() {
        viewModelScope.launch {
            when (val result = getTransactionsUseCase()) {
                is RequestResult.Success -> {
                    _state.value = HomeViewModelState()
                    _state.value = HomeViewModelState(transactions = groupTransactionsByDate(result.data))
                }
                is RequestResult.Error -> showErrorWith(result.error)
                else -> {}
            }
        }
    }

    fun fetchSponsoringCards() {
        viewModelScope.launch {
            when (val result = getSponsoringCardsUseCase()) {
                is RequestResult.Success -> {
                    _state.value = HomeViewModelState()
                    _state.value = HomeViewModelState(sponsoringCards = result.data)
                }
                is RequestResult.Error -> showErrorWith(result.error)
            }
        }
    }


    private fun showErrorWith(validation: RootError?) {
        _state.value = HomeViewModelState(error = validation)
        _state.value = HomeViewModelState()
    }

    private fun groupTransactionsByDate(transactions: List<Transaction>): List<TransactionItem> {
        val groupedTransactions = mutableListOf<TransactionItem>()
        val transactionsByDate = transactions.groupBy { it.date }
        for ((date, transactions) in transactionsByDate) {
            groupedTransactions.add(TransactionItem.DateHeader(date))
            groupedTransactions.addAll(transactions.map { TransactionItem.TransactionDetail(it) })
        }
        return groupedTransactions
    }
}
