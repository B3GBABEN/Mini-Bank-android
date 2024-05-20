package com.baben.apps.appformation3.data.validation.cases

import com.b3g.fawri.minibank.core.utils.errors.RequestResult
import com.b3g.fawri.minibank.core.utils.errors.ValidationError

fun PasswordValidation(password: String): RequestResult<Unit, ValidationError> {
    if (password.trim().isBlank() || password == "null") return RequestResult.Error(ValidationError.PasswordError.EMPTY)
    return RequestResult.Success(Unit)
}