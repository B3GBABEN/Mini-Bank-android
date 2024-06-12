package com.b3g.fawri.minibank.presentation.screens.home.transactions

import com.b3g.fawri.minibank.data.remote.moels.Transaction


sealed class TransactionItem {
    data class DateHeader(val date: String) : TransactionItem()
    data class TransactionDetail(val transaction: Transaction) : TransactionItem()
}
