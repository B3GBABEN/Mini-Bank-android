package com.b3g.fawri.minibank.ui.Activation_compte
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageView
import androidx.viewpager2.widget.ViewPager2
import com.b3g.fawri.minibank.R


class Step2Activationcompte: Fragment() {

    private lateinit var otpEditTexts: List<AppCompatEditText>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.step2_activation, container, false)
        otpEditTexts = listOf(
            view.findViewById(R.id.otp_edit_text1_s2act),
            view.findViewById(R.id.otp_edit_text2_s2act),
            view.findViewById(R.id.otp_edit_text3_s2act),
            view.findViewById(R.id.otp_edit_text4_s2act),
            view.findViewById(R.id.otp_edit_text5_s2act),
            view.findViewById(R.id.otp_edit_text6_s2act)
        )

        for (editText in otpEditTexts) {
            editText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable?) {
                    val isEmpty = s.isNullOrEmpty()
                    editText.setBackgroundResource(if (isEmpty) R.drawable.bg_otp_empty else R.drawable.bg_otp_filled)
                }
            })

            // Définir le fond dès le début
            val isEmpty = editText.text.isNullOrEmpty()
            editText.setBackgroundResource(if (isEmpty) R.drawable.bg_otp_empty else R.drawable.bg_otp_filled)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Récupérer le ViewPager2 de l'activité parente
        val viewPager = requireActivity().findViewById<ViewPager2>(R.id.viewPagerActivation)

        // Récupérer le bouton "Suivant"
        val nextButton = view.findViewById<Button>(R.id.next_button2_s2act)

        // Ajouter un OnClickListener au bouton "Suivant"
        nextButton.setOnClickListener {
            // Passer à l'index suivant dans le ViewPager (Step3Fragment=2 position )
            viewPager.setCurrentItem(viewPager.currentItem + 1, true)
        }
        // Récupérer le bouton de retour
        val backButton = view.findViewById<AppCompatImageView>(R.id.back_button2_s2act)

        // Ajouter un OnClickListener au bouton de retour
        backButton.setOnClickListener {
            // Passer à l'index précédent dans le ViewPager
            viewPager.setCurrentItem(viewPager.currentItem - 1, true)
        }
    }

}
