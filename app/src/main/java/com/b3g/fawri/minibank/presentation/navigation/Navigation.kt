package com.b3g.fawri.minibank.presentation.navigation

import android.content.Context
import android.content.Intent
import com.b3g.fawri.minibank.presentation.screens.Activation_compte.Activationcompte
import com.b3g.fawri.minibank.presentation.screens.Transactions.TransactionActivity
import com.b3g.fawri.minibank.presentation.screens.factures.FactureActivity
import com.b3g.fawri.minibank.presentation.screens.home.HomeActivity
import com.b3g.fawri.minibank.presentation.screens.login.LoginActivity

object Navigation {




    // Navigate to HomeActivity
    fun navigateToHome(context: Context) {
        val intent = Intent(context, HomeActivity::class.java)
        intent.flags =
            (Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK) and Intent.FLAG_ACTIVITY_CLEAR_TOP
        context.startActivity(intent)
    }
    fun navigateToFactures(context: Context) {
        val intent = Intent(context, FactureActivity::class.java)
        intent.flags =
            (Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK) and Intent.FLAG_ACTIVITY_CLEAR_TOP
        context.startActivity(intent)
    }
    fun navigateToLogin(context: Context) {
        val intent = Intent(context, LoginActivity::class.java)
        intent.flags =
            (Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK) and Intent.FLAG_ACTIVITY_CLEAR_TOP
        context.startActivity(intent)
    }
    fun navigateToTransaction(context: Context) {
        val intent = Intent(context, TransactionActivity::class.java)
        intent.flags =
            (Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK) and Intent.FLAG_ACTIVITY_CLEAR_TOP
        context.startActivity(intent)
    }
    fun navigateToAccountActivation(context: Context) {
        val intent = Intent(context, Activationcompte::class.java)
        intent.flags =
            (Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK) and Intent.FLAG_ACTIVITY_CLEAR_TOP
        context.startActivity(intent)
    }
    fun navigateToLegalMention(context: Context) {
        val intent = Intent(context, Activationcompte::class.java)
        intent.flags =
            (Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK) and Intent.FLAG_ACTIVITY_CLEAR_TOP
        context.startActivity(intent)
    }
    fun navigateToAbout(context: Context) {
        val intent = Intent(context, Activationcompte::class.java)
        intent.flags =
            (Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK) and Intent.FLAG_ACTIVITY_CLEAR_TOP
        context.startActivity(intent)
    }
}