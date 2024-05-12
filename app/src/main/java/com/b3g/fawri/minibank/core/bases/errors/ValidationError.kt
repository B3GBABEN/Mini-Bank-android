package com.b3g.fawri.minibank.core.bases.errors



 sealed interface ValidationError : Error{

    enum class UserIdError : ValidationError {
        EMPTY,
    }
    enum class PasswordError : ValidationError {
        EMPTY,
    }

}