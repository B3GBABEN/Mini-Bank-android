package com.b3g.fawri.minibank.core.bases.errors

sealed interface DataError: Error {
    enum class Network : DataError {
        NO_INTERNET,
        AUTH_FAILED,
        FORBIDEN,
        SERVER_ERROR
    }
    enum class Local : DataError {
        SYSTEM
    }
}