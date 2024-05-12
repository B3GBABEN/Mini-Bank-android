package com.b3g.fawri.minibank.presentation.activities.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.b3g.fawri.minibank.data.validation.LoginValidation
import com.b3g.fawri.minibank.domain.repositories.LoginRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel(private val repository: LoginRepository): ViewModel() {
    data class LoginViewModelState(
        val isLoading : Boolean = false,
        val isSuccess : Boolean = false,
        val error: Error? = null
    )
    private val _state = MutableStateFlow(LoginViewModelState())
    private val _userId = MutableLiveData<String>()
    private val _password = MutableLiveData<String>()
    val userId : LiveData<String> =  _userId
    val password : LiveData<String> =_password
    val state = _state.asStateFlow()

    fun setUserId(id : String)
{
  _userId.value=id
}
  fun setPassword(pass : String)
{
_password.value=pass
}

    fun validateCredential(): Boolean
    {
        val userId=_userId.value
        val password=_password.value
        return !userId.isNullOrEmpty()&& !password.isNullOrEmpty()
    }
fun login()
{
val userId= _userId.value.toString()
    val password=_password.value.toString()
    val validation= LoginValidation.validateLoginData(userId,password)

}




}