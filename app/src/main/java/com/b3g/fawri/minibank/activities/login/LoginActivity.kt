package com.b3g.fawri.minibank.activities.login

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.b3g.fawri.minibank.databinding.ActivityLoginBinding
import com.b3g.fawri.minibank.widgets.CustomedEditText
class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var loginViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        clearSelection()
        setupViewsActions()
    }


    private fun clearSelection() {
        binding.keyboard.visibility = View.GONE
        binding.clientId.isSelected = false
        binding.password.isSelected = false
    }

    private fun setupViewsActions() {
        customEditTextClickAction(binding.clientId)
        customEditTextClickAction(binding.password)
        binding.buttonConnexion.setOnClickListener { connexion(it) }
    }

    private fun customEditTextClickAction(field: CustomedEditText) {
        field.setOnClickListener {
            clearSelection()
            field.isSelected = true
            binding.keyboard.setEditText(field.getEditText())
            binding.keyboard.visibility = View.VISIBLE
            field.getEditText().requestFocus()
        }

    }
    private fun connexion(view: View) {

    }

}