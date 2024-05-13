package com.b3g.fawri.minibank.data.validation.remote.moels
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
data class LoginOutputDto(
    @SerialName("token")
    val token: String? = null
)