package com.b3g.fawri.minibank.core.utils.errors



 sealed interface ValidationError : Error {

    enum class UserIdError : ValidationError {
        EMPTY,
    }
    enum class PasswordError : ValidationError {
        EMPTY,
    }

}