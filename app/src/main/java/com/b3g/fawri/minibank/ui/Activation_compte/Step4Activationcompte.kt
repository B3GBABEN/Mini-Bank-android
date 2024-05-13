package com.b3g.fawri.minibank.ui.Activation_compte

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.b3g.fawri.minibank.R

class Step4Activationcompte : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Charge le layout XML pour cet fragment
        return inflater.inflate(R.layout.step4_activation, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Récupérer le ViewPager2 de l'activité parente
        val viewPager = requireActivity().findViewById<ViewPager2>(R.id.viewPagerActivation)

        // Récupérer le bouton de retour
        val backButton = view.findViewById<AppCompatImageView>(R.id.back_button4_s4act)

        // Ajouter un OnClickListener au bouton de retour
        backButton.setOnClickListener {
            // Passer à l'index précédent dans le ViewPager
            viewPager.setCurrentItem(viewPager.currentItem - 1, true)
        }
    }
}