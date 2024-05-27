package com.b3g.fawri.minibank.presentation.screens.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.b3g.fawri.minibank.R
import com.b3g.fawri.minibank.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    // Handle Home action
                    true
                }
                R.id.navigation_transfers -> {
                    // Handle Transfers action
                    true
                }
                R.id.navigation_cards -> {
                    // Handle Cards action
                    true
                }
                R.id.navigation_bills -> {
                    // Handle Bills action
                    true
                }
                else -> false
            }
        }

        val cardList = listOf(
            CardItem(R.drawable.card_background, "MiniBank", "**** **** **** 1234", "Compte Courant", "52 000,00 MAD", R.drawable.ic_switch_off),
            CardItem(R.drawable.card_background, "MiniBank", "**** **** **** 5678", "Compte Courant", "20 000,00 MAD", R.drawable.ic_switch_off),
            CardItem(R.drawable.card_background, "MiniBank", "**** **** **** 9101", "Compte Courant", "10 000,00 MAD", R.drawable.ic_switch_off)
        )

        binding.viewPager.adapter = CardAdapter(cardList)
        binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }
}
