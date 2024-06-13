package com.b3g.fawri.minibank.presentation.screens.factures

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class SectionsPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FactureFragment()
            1 -> HistoriqueFactureFragment()
            else -> throw IllegalStateException("Unexpected position $position")
        }
    }
}
