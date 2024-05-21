package com.b3g.fawri.minibank.presentation.screens.Activation_compte
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.b3g.fawri.minibank.R

class Activationcompte : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activationpwd)

        val viewPager: ViewPager2 = findViewById(R.id.viewPagerActivation)
        val adapter = ActivationcomptePagerAdapter(this)
        viewPager.adapter = adapter

        // Définir la position initiale du ViewPager sur 0 (Step1Fragment)
        viewPager.setCurrentItem(0, false)
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                updateStepIndicator(position)
            }
        })
    }
    private fun updateStepIndicator(position: Int) {
        val indicator1 = findViewById<View>(R.id.indicator_1)
        val indicator2 = findViewById<View>(R.id.indicator_2)
        val indicator3 = findViewById<View>(R.id.indicator_3)
        val indicator4 = findViewById<View>(R.id.indicator_4)

        when (position) {
            0 -> {
                indicator1.setBackgroundResource(R.drawable.circle_blue)
                indicator2.setBackgroundResource(R.drawable.circle_empty)
                indicator3.setBackgroundResource(R.drawable.circle_empty)
                indicator4.setBackgroundResource(R.drawable.circle_empty)
            }
            1 -> {
                indicator1.setBackgroundResource(R.drawable.circle_empty)
                indicator2.setBackgroundResource(R.drawable.circle_blue)
                indicator3.setBackgroundResource(R.drawable.circle_empty)
                indicator4.setBackgroundResource(R.drawable.circle_empty)
            }
            2 -> {
                indicator1.setBackgroundResource(R.drawable.circle_empty)
                indicator2.setBackgroundResource(R.drawable.circle_empty)
                indicator3.setBackgroundResource(R.drawable.circle_blue)
                indicator4.setBackgroundResource(R.drawable.circle_empty)
            }
            3 -> {
                indicator1.setBackgroundResource(R.drawable.circle_empty)
                indicator2.setBackgroundResource(R.drawable.circle_empty)
                indicator3.setBackgroundResource(R.drawable.circle_empty)
                indicator4.setBackgroundResource(R.drawable.circle_blue)
            }
        }
    }


}


