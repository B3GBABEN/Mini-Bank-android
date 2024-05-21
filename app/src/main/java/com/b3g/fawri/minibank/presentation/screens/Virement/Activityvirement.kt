package com.b3g.fawri.minibank.presentation.screens.Virement
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.b3g.fawri.minibank.R
import com.b3g.fawri.minibank.ui.ForgetpwdPagerAdapter
import com.google.android.material.tabs.TabLayout

class Activityvirement : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_virement)



        // Initialize Buttons
        val buttonVirement = findViewById<Button>(R.id.button_virement)
        val buttonHistorique = findViewById<Button>(R.id.button_historique)

        // Set onClickListener for Virement button
        buttonVirement.setOnClickListener {
            val viewPager: ViewPager2 = findViewById(R.id.viewPager)
            val adapter = ForgetpwdPagerAdapter(this)
            viewPager.adapter = adapter

            // Définir la position initiale du ViewPager sur 0 (Step1Fragment)
            viewPager.setCurrentItem(0, false)
        }

        // Set onClickListener for Historique button
        buttonHistorique.setOnClickListener {

        }
    }
}
