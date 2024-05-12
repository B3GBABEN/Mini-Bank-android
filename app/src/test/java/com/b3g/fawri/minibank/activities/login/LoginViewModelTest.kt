package com.b3g.fawri.minibank.activities.login

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)

class LoginViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    val USERID: String = "userid"
     val PASSWORD: String = "password"
    lateinit var sut : LoginViewModel

@Before
fun setUp()
{
sut= LoginViewModel()
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
  /*  @Test
    fun login()
    {
      val valide : Boolean =  sut.validateCredential()
        Assert.assertTrue(valide)


    }*/


}