package com.b3g.fawri.minibank.activities.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {
private val _userId= MutableLiveData<String>()
private val _password= MutableLiveData<String>()
val userId : LiveData<String> =  _userId
        val password : LiveData<String> =_password
fun setUserId(userId : String)
{
_userId.value=userId
}
  fun setPassword(password : String)
{
_password.value=password
}
    fun getUserId() : LiveData<String>
    {
        return  _userId
    }
    fun getPassword() : LiveData<String>
    {
        return  _password
    }


}