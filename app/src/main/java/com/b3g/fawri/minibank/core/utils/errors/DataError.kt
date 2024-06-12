package com.b3g.fawri.minibank.core.utils.errors

sealed interface DataError: Error {
    enum class Network : DataError {
        NO_INTERNET,
        AUTH_FAILED,
        FORBIDEN,
        SERVER_ERROR,
        ACCOUNT_ERROR,
        SPONSOR_ERROR,
        TRANSACTION_ERROR
    }
    enum class Local : DataError {
        SYSTEM
    }
}