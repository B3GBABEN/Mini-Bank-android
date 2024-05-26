package com.b3g.fawri.minibank.presentation.screens.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.b3g.fawri.minibank.R
import com.b3g.fawri.minibank.databinding.ActivityHomeBinding
import com.b3g.fawri.minibank.databinding.ActivityMainBinding

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


    }
}