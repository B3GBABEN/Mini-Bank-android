package com.b3g.fawri.minibank.presentation.activities.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.b3g.fawri.minibank.core.bases.errors.Resource
import com.b3g.fawri.minibank.core.bases.errors.RootError
import com.b3g.fawri.minibank.data.validation.LoginValidation
import com.b3g.fawri.minibank.domain.usecases.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
@HiltViewModel
class LoginViewModel @Inject constructor (
    private val loginUseCase: LoginUseCase,
) : ViewModel() {
    data class LoginViewModelState(
        val isLoading: Boolean = false,
        val isSuccess: Boolean = false,
        val error: RootError? = null
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

   /* fun validateCredential(): Boolean
    {
        val userId=_userId.value
        val password=_password.value
        return !userId.isNullOrEmpty()&& !password.isNullOrEmpty()
    }*/
fun login()
{
    val userId= _userId.value.toString()
    val password=_password.value.toString()
    val validation= LoginValidation.validateLoginData(userId,password)
    when {
        validation != null -> _state.value = LoginViewModelState(error = validation)
        else ->{
            loginUseCase(userId = userId,password = password).onEach {
                when(it){
                    is Resource.Error -> _state.value = LoginViewModelState(error = it.message)
                    is Resource.Loading -> _state.value = LoginViewModelState(isLoading = true)
                    is Resource.Success -> {
                        _state.value = LoginViewModelState(isSuccess = true)
                    }
                }
            }.launchIn(viewModelScope)
        }

    }

}




}