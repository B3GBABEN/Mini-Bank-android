package com.b3g.fawri.minibank.ui.Activation_compte
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.b3g.fawri.minibank.R


class   Step1Activationcompte : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Charge le layout XML pour cet fragment
        return inflater.inflate(R.layout.step1_activation, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Récupérer le ViewPager2 de l'activité parente
        val viewPager = requireActivity().findViewById<ViewPager2>(R.id.viewPagerActivation)

        // Récupérer le bouton "Suivant"
        val nextButton = view.findViewById<Button>(R.id.next_button_st1act)

        // Ajouter un OnClickListener au bouton "Suivant"
        nextButton.setOnClickListener {
            // Passer à l'étape suivante (position 1 correspond à Step2Fragment)
            viewPager.currentItem = 1
        }

    }

}

