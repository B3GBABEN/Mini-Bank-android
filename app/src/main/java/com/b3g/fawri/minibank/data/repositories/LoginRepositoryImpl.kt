package com.b3g.fawri.minibank.data.repositories
import com.b3g.fawri.minibank.core.utils.errors.DataError
import com.b3g.fawri.minibank.core.utils.errors.RequestResult
import com.b3g.fawri.minibank.core.utils.errors.RequestResult.Success
import com.b3g.fawri.minibank.core.utils.errors.RootError
import com.b3g.fawri.minibank.data.validation.remote.moels.LoginOutputDto
import com.b3g.fawri.minibank.data.validation.remote.moels.retrofit.ClientApi
import com.b3g.fawri.minibank.domain.models.Login
import com.b3g.fawri.minibank.domain.repositories.LoginRepository
import kotlinx.coroutines.delay
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(private val api: ClientApi) : LoginRepository {

 private val token = "123"
    override suspend fun login(model: Login): RequestResult<String, RootError> {
    delay(2000L)
        if (model.userId == "1234" && model.password == "1234")
        {
           // val response = api.login(model)
            return RequestResult.Success(token)
        }
        else
            return   RequestResult.Error(DataError.Network.AUTH_FAILED)

    }
    //TODO

}