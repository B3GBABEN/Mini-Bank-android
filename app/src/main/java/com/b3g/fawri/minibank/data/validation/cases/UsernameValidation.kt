package com.baben.apps.appformation3.data.validation.cases

import com.b3g.fawri.minibank.core.bases.errors.RequestResult
import com.b3g.fawri.minibank.core.bases.errors.ValidationError

fun UsernameValidation(username: String): RequestResult<Unit, ValidationError> {
    if (username.trim().isBlank() || username == "null") return RequestResult.Error(ValidationError.UserIdError.EMPTY)
    return RequestResult.Success(Unit)
}