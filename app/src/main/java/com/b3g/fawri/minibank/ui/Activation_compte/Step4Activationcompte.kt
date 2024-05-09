package com.b3g.fawri.minibank.ui.Activation_compte

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.b3g.fawri.minibank.R

class Step4Activationcompte : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Charge le layout XML pour cet fragment
        return inflater.inflate(R.layout.step4_layout, container, false)
    }
}