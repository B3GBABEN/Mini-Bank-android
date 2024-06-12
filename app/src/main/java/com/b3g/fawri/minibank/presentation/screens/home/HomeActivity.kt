package com.b3g.fawri.minibank.presentation.screens.home

import NavDrawerAdapter
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.b3g.fawri.minibank.R
import com.b3g.fawri.minibank.core.bases.BaseActivities
import com.b3g.fawri.minibank.core.utils.extention.asString
import com.b3g.fawri.minibank.databinding.ActivityHomeBinding
import com.b3g.fawri.minibank.presentation.navigation.Navigation.navigateToAbout
import com.b3g.fawri.minibank.presentation.navigation.Navigation.navigateToAccountActivation
import com.b3g.fawri.minibank.presentation.navigation.Navigation.navigateToLegalMention
import com.b3g.fawri.minibank.presentation.navigationDrawer.MenuManager
import com.b3g.fawri.minibank.presentation.popups.Popup.showLanguageSelectionPopup
import com.b3g.fawri.minibank.presentation.screens.dialogs.Alert
import com.b3g.fawri.minibank.presentation.screens.home.cards.CardAdapter
import com.b3g.fawri.minibank.presentation.screens.home.cards.SponsoringCardAdapter
import com.b3g.fawri.minibank.presentation.screens.home.transactions.TransactionAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class HomeActivity : BaseActivities(), NavDrawerAdapter.OnItemClickListener {
    private lateinit var binding: ActivityHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
        setupTabLayoutDots()
        observeViewModelState()
    }

    private fun setupUI() {
        setupDrawerMenu()
        setupCardAdapter()
        setupTransactionAdapter()
        setupSponsoringCardAdapter()
    }

    private fun setupDrawerMenu() {
        binding.appHeaderr.imgButton.setOnClickListener {
            openMenu()
        }
        MenuManager.setOnlineMenu(this, binding)
    }

    private fun setupCardAdapter() {
        val cardAdapter = CardAdapter(emptyList())
        binding.viewPager.adapter = cardAdapter
    }

    private fun setupTransactionAdapter() {
        val transactionAdapter = TransactionAdapter(emptyList())
        binding.transactions.transactionRecyclerView.apply {
            adapter = transactionAdapter
            layoutManager = LinearLayoutManager(this@HomeActivity)
        }
    }

    private fun setupSponsoringCardAdapter() {
        val sponsoringCardAdapter = SponsoringCardAdapter(emptyList())
        binding.sponsoringCardsRecyclerView.apply {
            adapter = sponsoringCardAdapter
            layoutManager = LinearLayoutManager(this@HomeActivity, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun openMenu() {
        binding.drawerLayout.openDrawer(binding.navView)
    }

    private fun setupTabLayoutDots() {
        TabLayoutMediator(binding.tabLayoutDots, binding.viewPager) { tab, position ->
        }.attach()
    }

    private fun observeViewModelState() {
        viewModel.state.onEach { state ->
            state.accounts?.let {
                (binding.viewPager.adapter as CardAdapter).setItems(it)
            }
            state.transactions?.let {
                (binding.transactions.transactionRecyclerView.adapter as TransactionAdapter).setItems(it)
            }
            state.sponsoringCards?.let {
                (binding.sponsoringCardsRecyclerView.adapter as SponsoringCardAdapter).setItems(it)
            }
            state.error?.let {
                Alert.show(context = this, message = it.asString(context), backgroundColor = R.drawable.edittext_background)
            }
        }.launchIn(lifecycleScope)
    }

    override fun onItemClick(position: Int) {
        when (position) {
            0 -> {
                navigateToAccountActivation(this)
            }
            1 -> {
                showLanguageSelectionPopup(this, binding.navRecyclerView)
            }
            2 -> {
                navigateToLegalMention(this)
            }
            3 -> {
                navigateToAbout(this)
            }
        }
        binding.drawerLayout.closeDrawers()
    }
}
