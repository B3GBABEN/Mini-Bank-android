package com.b3g.fawri.minibank.activities.login

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)

class LoginViewModelTest {
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
        sut.setUserId(PASSWORD)
Assert.assertEquals(PASSWORD,sut.password.value)
    }


}