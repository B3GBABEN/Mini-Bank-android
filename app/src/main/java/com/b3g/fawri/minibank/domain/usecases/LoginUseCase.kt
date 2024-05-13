package com.b3g.fawri.minibank.domain.usecases

import com.b3g.fawri.minibank.core.bases.errors.DataError
import com.b3g.fawri.minibank.core.bases.errors.Resource
import com.b3g.fawri.minibank.domain.models.Login
import com.b3g.fawri.minibank.domain.repositories.LoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: LoginRepository
) {
    operator fun invoke(userId: String, password: String): Flow<Resource<String>> = flow {
        try {
            emit(Resource.Loading())
            val model = Login(userId = userId, password = password)
            val result = repository.login(model)
            if (result.token != null) {
                emit(Resource.Success(result.token.toString()))
            } else {
                emit(Resource.Error(DataError.Network.AUTH_FAILED))
            }
        } catch (e: HttpException) {
            when (e.code()) {
                401 -> emit(Resource.Error(DataError.Network.FORBIDEN))
                else -> {
                    emit(Resource.Error(DataError.Network.SERVER_ERROR))
                }
            }
        } catch (e: IOException) {
            emit(Resource.Error(DataError.Network.NO_INTERNET))
        } catch (e: Exception) {
            emit(Resource.Error(DataError.Local.SYSTEM))
        }

    }

}