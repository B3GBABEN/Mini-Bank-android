package com.b3g.fawri.minibank.core.bases.errors

sealed interface DataError: Error {
    enum class Network : DataError {
        REQUEST_TIMEOUT,
        NO_INTERNET,
        AUTH_FAILED
    }
}