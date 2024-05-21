package com.b3g.fawri.minibank.presentation.screens.Virement

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class VirementPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> Step1FragmentVirement()
            1 -> Step2FragmentVirement()
            2 -> Step3FragmentVirement()
            3 -> Step4FragmentVirement()
            else -> Fragment()
        }
    }

    override fun getCount(): Int {
        return 4 // Nombre total d'étapes du virement
    }
}

