package com.b3g.fawri.minibank.data.repositories
import com.b3g.fawri.minibank.data.validation.remote.moels.LoginOutputDto
import com.b3g.fawri.minibank.data.validation.remote.moels.retrofit.ClientApi
import com.b3g.fawri.minibank.domain.models.Login
import com.b3g.fawri.minibank.domain.repositories.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(val api: ClientApi) : LoginRepository {


    override suspend fun login(model: Login): LoginOutputDto {
        return api.userLogin(model)

    }
}