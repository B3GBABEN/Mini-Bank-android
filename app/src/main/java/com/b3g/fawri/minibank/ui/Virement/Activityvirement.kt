package com.b3g.fawri.minibank.ui.Virement
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

        // Initialize ViewPager
        val viewPager = findViewById<ViewPager>(R.id.view_pager)
        viewPager.adapter = VirementPagerAdapter(supportFragmentManager)

        // Initialize TabLayout
        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        tabLayout.setupWithViewPager(viewPager)

        // Set onClickListener for Virement button
        buttonVirement.setOnClickListener {
            viewPager.currentItem = 0 // Affiche l'étape 1 du virement
        }

        // Set onClickListener for Historique button
        buttonHistorique.setOnClickListener {
            // Implémentez la logique pour le bouton Historique
        }
    }

}
