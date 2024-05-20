package com.b3g.fawri.minibank.presentation.navigation

import android.content.Context
import android.content.Intent
import com.b3g.fawri.minibank.presentation.screens.home.HomeActivity

object Navigation {




    // Navigate to HomeActivity
    fun navigateToHome(context: Context) {
        val intent = Intent(context, HomeActivity::class.java)
        intent.flags =
            (Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK) and Intent.FLAG_ACTIVITY_CLEAR_TOP
        context.startActivity(intent)
    }
    fun navigateToAccountActivation(context: Context) {
        val intent = Intent(context, HomeActivity::class.java)
        intent.flags =
            (Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK) and Intent.FLAG_ACTIVITY_CLEAR_TOP
        context.startActivity(intent)
    }
    fun navigateToLegalMention(context: Context) {
        val intent = Intent(context, HomeActivity::class.java)
        intent.flags =
            (Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK) and Intent.FLAG_ACTIVITY_CLEAR_TOP
        context.startActivity(intent)
    }
    fun navigateToAbout(context: Context) {
        val intent = Intent(context, HomeActivity::class.java)
        intent.flags =
            (Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK) and Intent.FLAG_ACTIVITY_CLEAR_TOP
        context.startActivity(intent)
    }
}