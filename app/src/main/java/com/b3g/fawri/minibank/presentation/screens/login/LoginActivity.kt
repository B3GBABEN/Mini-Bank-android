package com.b3g.fawri.minibank.presentation.screens.login

import NavDrawerAdapter
import NavDrawerItem
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.b3g.fawri.minibank.R
import com.b3g.fawri.minibank.presentation.navigation.Navigation
import com.b3g.fawri.minibank.widgets.CustomedEditText
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import dagger.hilt.android.AndroidEntryPoint
import  com.b3g.fawri.minibank.core.bases.BaseActivities
import com.b3g.fawri.minibank.core.utils.extention.asString
import com.b3g.fawri.minibank.databinding.ActivityLoginBinding
import com.b3g.fawri.minibank.presentation.navigation.Navigation.navigateToAbout
import com.b3g.fawri.minibank.presentation.navigation.Navigation.navigateToAccountActivation
import com.b3g.fawri.minibank.presentation.navigation.Navigation.navigateToHome
import com.b3g.fawri.minibank.presentation.navigation.Navigation.navigateToLegalMention
import com.b3g.fawri.minibank.presentation.navigation.Navigation.navigateToTransaction
import com.b3g.fawri.minibank.presentation.navigationDrawer.MenuManager
import com.b3g.fawri.minibank.presentation.popups.Popup.showLanguageSelectionPopup
import com.b3g.fawri.minibank.presentation.screens.dialogs.Alert

@AndroidEntryPoint
class LoginActivity : BaseActivities(), NavDrawerAdapter.OnItemClickListener {
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.loginView.appHeaderr.logoHeaderHome.visibility = View.GONE
        clearSelection()
        setupViewsActions()
        viewModelStateObserver()
        setupMenu()

    }
    private fun setupMenu() {
        MenuManager.setOfflineMenu(this, binding)
    }

    private fun openMenu() {
        binding.drawerLayout.openDrawer(binding.navView)
    }


    private fun viewModelStateObserver() {
        viewModel.state.onEach { state ->
            when {
                state.isLoading -> startLoading(this)
                state.isSuccess -> {
                    navigateToHome(this)
                    finish()
                }

                state.error != null -> {
                    stopLoading(this)
                    Alert.show(context=this, message = state.error.asString(context),backgroundColor =R.drawable.edittext_background)

                }
            }
        }.launchIn(lifecycleScope)
    }

    private fun clearSelection() {
        binding.loginView.keyboard.visibility = View.GONE
        binding.loginView.clientId.isSelected = false
        binding.loginView.password.isSelected = false
    }

    private fun setupViewsActions() {
        customEditTextClickAction(binding.loginView.clientId)
        customEditTextClickAction(binding.loginView.password)
        binding.loginView.buttonConnexion.setOnClickListener(this::connexion)
        binding.loginView.forgotButton.setOnClickListener { forgotPassword() }
        binding.loginView.appHeaderr.imgButton.setOnClickListener {         openMenu()}
    }

    private fun forgotPassword() {
        TODO("Not yet implemented")
    }

    private fun customEditTextClickAction(field: CustomedEditText) {
        field.setOnClickListener {
            clearSelection()
            field.isSelected = true
            binding.loginView.keyboard.setEditText(field.getEditText())
            binding.loginView.keyboard.visibility = View.VISIBLE
        }

    }


    private fun connexion(view: View) {
        val userId = binding.loginView.clientId.getText()
        val password = binding.loginView.password.getText()
        viewModel.login(userId,password)

    }

    override fun onItemClick(position: Int) {
        when (position) {
            0 -> {
                navigateToAccountActivation(this)
            }
            1 -> {
                showLanguageSelectionPopup(this,binding.navRecyclerView)
            }
            2 -> {
                navigateToLegalMention(this)
            }
            3 -> {
                navigateToAbout(this)
            }
        }
        binding.drawerLayout.closeDrawers()    }

}
