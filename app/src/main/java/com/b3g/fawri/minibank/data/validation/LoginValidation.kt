package com.b3g.fawri.minibank.data.validation

import com.b3g.fawri.minibank.core.bases.errors.RequestResult
import com.b3g.fawri.minibank.core.bases.errors.RootError
import com.baben.apps.appformation3.data.validation.cases.PasswordValidation
import com.baben.apps.appformation3.data.validation.cases.UsernameValidation

object LoginValidation {
    fun validateLoginData(username: String, password: String): RootError? {
        val userIdResult = UsernameValidation(username)
        if (userIdResult is RequestResult.Error) return userIdResult.error
        val passwordResult = PasswordValidation(password)
        if (passwordResult is RequestResult.Error) return passwordResult.error
        return null
    }
}