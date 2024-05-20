package com.b3g.fawri.minibank.presentation.screens.Activation_compte

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.b3g.fawri.minibank.R

class Step3Activationcompte : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Charge le layout XML pour cet fragment
        return inflater.inflate(R.layout.step3_activation, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Récupérer le ViewPager2 de l'activité parente
        val viewPager = requireActivity().findViewById<ViewPager2>(R.id.viewPagerActivation)

        // Récupérer le bouton "Suivant"
        val nextButton = view.findViewById<Button>(R.id.next_button3_st3act)

        // Ajouter un OnClickListener au bouton "Suivant"
        nextButton.setOnClickListener {
            // Passer à l'index suivant dans le ViewPager (Step3Fragment=2 position )
            viewPager.setCurrentItem(viewPager.currentItem + 1, true)
        }
        // Récupérer le bouton de retour
        val backButton = view.findViewById<AppCompatImageView>(R.id.back_button3_s3act)

        // Ajouter un OnClickListener au bouton de retour
        backButton.setOnClickListener {
            // Passer à l'index précédent dans le ViewPager
            viewPager.setCurrentItem(viewPager.currentItem - 1, true)
        }
    }
}