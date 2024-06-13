// FactureActivity.kt
package com.b3g.fawri.minibank.presentation.screens.factures

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.b3g.fawri.minibank.R
import com.b3g.fawri.minibank.databinding.ActivityFactureBinding
import com.b3g.fawri.minibank.databinding.HistoriqueFactureBinding
import com.b3g.fawri.minibank.presentation.navigation.Navigation.navigateToHome
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class FactureActivity : AppCompatActivity() {
    private lateinit var binding: HistoriqueFactureBinding
    private val viewModel: HistoriqueFactureViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HistoriqueFactureBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupBackButton()

        val sectionsPagerAdapter = SectionsPagerAdapter(this)
        binding.viewPager.adapter = sectionsPagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Factures"
                1 -> "Historique"
                else -> null
            }
        }.attach()
    }
    private fun setupBackButton() {
        binding.backFromFacture.setOnClickListener {
            navigateToHome(this)
        }
    }
}
