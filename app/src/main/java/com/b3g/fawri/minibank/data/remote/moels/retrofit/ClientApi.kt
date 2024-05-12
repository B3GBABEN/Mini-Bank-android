package com.b3g.fawri.minibank.data.validation.remote.moels.retrofit

import com.b3g.fawri.minibank.data.validation.remote.moels.LoginOutputDto
import com.b3g.fawri.minibank.domain.models.Login
import retrofit2.http.Body
import retrofit2.http.POST


interface ClientApi {
    @POST("auth/login")
    suspend fun userLogin(
        @Body model : Login
    ) : LoginOutputDto
}