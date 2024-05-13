package com.b3g.fawri.minibank.presentation.activities.login

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.b3g.fawri.minibank.databinding.ActivityLoginBinding
import com.b3g.fawri.minibank.presentation.navigation.Navigation
import com.b3g.fawri.minibank.widgets.CustomedEditText
import com.b3g.fawri.minibank.widgets.keyboard.CustomKeyboard
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import dagger.hilt.android.AndroidEntryPoint
import  com.b3g.fawri.minibank.core.bases.BaseActivities

@AndroidEntryPoint
class LoginActivity : BaseActivities() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var loginViewModel: LoginViewModel
    lateinit var keyboard : CustomKeyboard
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        keyboard=binding.keyboard
        setContentView(binding.root)
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        clearSelection()
        setupViewsActions()

    }


    private fun viewModelStateObserver() {
        loginViewModel.state.onEach {state ->
            when {
                state.isLoading -> startLoading()
                state.isSuccess -> {
                    Navigation.navigateToHome(this@LoginActivity)
                    finish()
                }

                state.error != null -> {
                    stopLoading()

                }
            }
        }.launchIn(lifecycleScope)
    }

    private fun clearSelection() {
        keyboard.visibility = View.GONE
        binding.clientId.isSelected = false
        binding.password.isSelected = false
    }

    private fun setupViewsActions() {
        customEditTextClickAction(binding.clientId)
        customEditTextClickAction(binding.password)
        binding.buttonConnexion.setOnClickListener { connexion(it) }
        binding.forgotButton.setOnClickListener { forgotPassword() }
    }

    private fun forgotPassword() {
        TODO("Not yet implemented")
    }

    private fun customEditTextClickAction(field: CustomedEditText) {
        field.setOnClickListener {
            clearSelection()
            field.isSelected = true
            keyboard.setEditText(field.getEditText())
            keyboard.visibility = View.VISIBLE
        }

    }


    private fun connexion(view: View) {

    }

}