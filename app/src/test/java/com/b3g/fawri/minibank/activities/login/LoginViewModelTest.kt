package com.b3g.fawri.minibank.activities.login

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.b3g.fawri.minibank.activities.login.LoginViewModelTest.Companion.DELAY
import com.b3g.fawri.minibank.activities.login.LoginViewModelTest.Companion.PASSWORD
import com.b3g.fawri.minibank.activities.login.LoginViewModelTest.Companion.TOKEN
import com.b3g.fawri.minibank.activities.login.LoginViewModelTest.Companion.USERID
import com.b3g.fawri.minibank.core.bases.errors.DataError
import com.b3g.fawri.minibank.data.validation.remote.moels.LoginOutputDto
import com.b3g.fawri.minibank.domain.models.Login
import com.b3g.fawri.minibank.domain.repositories.LoginRepository
import com.b3g.fawri.minibank.domain.usecases.LoginUseCase
import com.b3g.fawri.minibank.presentation.activities.login.LoginViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import java.io.IOException

@RunWith(MockitoJUnitRunner::class)

class LoginViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    lateinit var sut : LoginViewModel
    private lateinit var loginRepository: MockLoginRepository
    companion object {
        const val USERID = "id123"
        const val PASSWORD = "password"
        const val TOKEN = "UserToken"
        const val DELAY=200L
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
fun setUp()
{
    Dispatchers.setMain(Dispatchers.Unconfined)
    loginRepository = MockLoginRepository()

    sut= LoginViewModel(LoginUseCase(loginRepository))

}
 @Test
    fun setUserIdTest()
    {
        sut.setUserId(USERID)
Assert.assertEquals(USERID,sut.userId.value)
    }
    @Test
    fun setPasswordTest()
    {
        sut.setPassword(PASSWORD)
Assert.assertEquals(PASSWORD,sut.password.value)
    }
    @Test
    fun usernameAndPasswordPassedToRepo() = runTest {
        loginSucceded()
        Assert.assertNotNull(loginRepository.loginModel)
        Assert.assertEquals(loginRepository.loginModel?.userId, USERID)
        Assert.assertEquals(loginRepository.loginModel?.password, PASSWORD)
    }
    @Test
    fun loginWithValidData() = runBlocking {
        loginSucceded()
        val loading = sut.state.value
        println("Loading state: $loading")
        Assert.assertTrue(loading.isLoading)
        delay(DELAY + 100)
        val result = sut.state.value
        println("Result state: $result")
        Assert.assertTrue(result.isSuccess)
    }
    @Test
    fun loginWithInvalidData() = runBlocking {
        val userId = "invalidUsername"
        val password = "invalidPassword"
        sut.setUserId(userId)
        sut.setPassword(password)
        sut.login()
        val loading = sut.state.value
        Assert.assertTrue(loading.isLoading)
        delay(DELAY + 100)
        val result = sut.state.value
        println("Actual error: ${result.error}")

        Assert.assertNotNull(result.error)
        Assert.assertEquals(result.error, DataError.Network.AUTH_FAILED)
    }
    private fun loginSucceded() {
        sut.setUserId(USERID)
        sut.setPassword(PASSWORD)
        sut.login()
    }

}

class MockLoginRepository : LoginRepository {
    var noInternet: Boolean = false
    var loginModel: Login? = null
    override suspend fun login(model: Login): LoginOutputDto {
        loginModel=model
        if (noInternet) throw IOException()
        delay(DELAY)
        if (model.userId ==USERID  && model.password == PASSWORD) {
            return LoginOutputDto(token = TOKEN)
        }
        return LoginOutputDto()
    }

}
