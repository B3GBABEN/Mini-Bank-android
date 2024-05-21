package com.b3g.fawri.minibank.presentation.screens.Activation_compte

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


class ActivationcomptePagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 4 // Nombre total d'étapes
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Step1Activationcompte()
            1 -> Step2Activationcompte()
            2 -> Step3Activationcompte()
            3 -> Step4Activationcompte()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }
}
