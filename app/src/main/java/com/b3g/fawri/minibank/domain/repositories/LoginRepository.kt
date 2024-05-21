package com.b3g.fawri.minibank.domain.repositories

import com.b3g.fawri.minibank.core.utils.errors.DataError
import com.b3g.fawri.minibank.core.utils.errors.RequestResult
import com.b3g.fawri.minibank.core.utils.errors.RootError
import com.b3g.fawri.minibank.data.validation.remote.moels.LoginOutputDto
import com.b3g.fawri.minibank.domain.models.Login

interface LoginRepository {
    suspend fun login(model : Login) : RequestResult<String, RootError>
}