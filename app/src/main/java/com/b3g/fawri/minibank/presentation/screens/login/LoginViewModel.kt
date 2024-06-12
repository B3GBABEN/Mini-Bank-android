package com.b3g.fawri.minibank.presentation.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.b3g.fawri.minibank.core.utils.errors.Resource
import com.b3g.fawri.minibank.core.utils.errors.RootError
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
    private val _state = MutableStateFlow(
        LoginViewModelState())
    val state = _state.asStateFlow()



fun login( userId :String,password : String)
{
    val validation = LoginValidation.validateLoginData(userId,password)
    when {
        validation != null -> showErrorWith(validation)
        else ->{
            loginUseCase(userId = userId,password = password).onEach {
                when(it){
                    is Resource.Error -> showErrorWith(it.message)
                    is Resource.Loading -> startLoading()
                    is Resource.Success -> {
                        _state.value = LoginViewModelState(isSuccess = true)
                    }

                    else -> {}
                }
            }.launchIn(viewModelScope)
        }

    }

}

    private fun startLoading() {
        _state.value = LoginViewModelState(isLoading = true)
    }

    private fun showErrorWith(validation: RootError?) {
        _state.value = LoginViewModelState(error = validation)
        _state.value = LoginViewModelState()
    }






}