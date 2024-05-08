package com.b3g.fawri.minibank.ui
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.b3g.fawri.minibank.R

class Forgetpassword : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_oublie)

        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val adapter = ForgetpwdPagerAdapter(this)
        viewPager.adapter = adapter

        // Définir la position initiale du ViewPager sur 0 (Step1Fragment)
        viewPager.setCurrentItem(0, false)
    }
}
