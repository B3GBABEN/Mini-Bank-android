package com.b3g.fawri.minibank.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.b3g.fawri.minibank.ui.Step1Fragment
import com.b3g.fawri.minibank.ui.Step2Fragment
import com.b3g.fawri.minibank.ui.Step3Fragment
import com.b3g.fawri.minibank.ui.Step4Fragment

class ForgetpwdPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 4 // Nombre total d'étapes
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Step1Fragment()
            1 -> Step2Fragment()
            2 -> Step3Fragment()
            3 -> Step4Fragment()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }
}