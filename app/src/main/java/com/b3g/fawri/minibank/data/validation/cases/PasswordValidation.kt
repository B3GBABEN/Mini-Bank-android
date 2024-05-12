package com.baben.apps.appformation3.data.validation.cases

import com.b3g.fawri.minibank.core.bases.errors.RequestResult
import com.b3g.fawri.minibank.core.bases.errors.ValidationError

fun PasswordValidation(password: String): RequestResult<Unit, ValidationError> {
    if (password.trim().isBlank() || password == "null") return RequestResult.Error(ValidationError.PasswordError.EMPTY)
    return RequestResult.Success(Unit)
}