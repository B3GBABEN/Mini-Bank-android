package com.b3g.fawri.minibank.ui.Virement

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class VirementPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> Step1FragmentVirement()
            1 -> Step2FragmentVirement()
            // Ajoutez d'autres étapes du virement ici
            else -> Fragment()
        }
    }

    override fun getCount(): Int {
        return 4 // Nombre total d'étapes du virement
    }
}

