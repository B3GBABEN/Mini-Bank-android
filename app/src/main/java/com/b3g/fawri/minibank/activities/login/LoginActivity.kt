package com.b3g.fawri.minibank.activities.login

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.b3g.fawri.minibank.R
import com.b3g.fawri.minibank.widgets.CustomedEditText
import com.b3g.fawri.minibank.widgets.keyboard.CustomKeyboard

class LoginActivity : AppCompatActivity() {
    private lateinit var uiClientId: CustomedEditText
    private lateinit var uiPassword: CustomedEditText
    private lateinit var uiKeyboardView: CustomKeyboard
    private lateinit var uiConnexion: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        findViews()
        clearSelection()
        setupViewsActions()
    }

    private fun findViews() {
        uiClientId = findViewById(R.id.clientId)
        uiPassword = findViewById(R.id.password)
        uiKeyboardView = findViewById(R.id.keyboard)
        uiConnexion = findViewById(R.id.button_connexion)
    }

    private fun clearSelection() {
        uiKeyboardView.visibility = View.GONE
        uiClientId.isSelected = false
        uiPassword.isSelected = false
    }

    private fun setupViewsActions() {
        customEditTextClickAction(uiClientId)
        customEditTextClickAction(uiPassword)
        uiConnexion.setOnClickListener { connexion(it) }
    }

    private fun customEditTextClickAction(field: CustomedEditText) {
        field.setOnClickListener {
            clearSelection()
            field.isSelected = true
            uiKeyboardView.setEditText(field.getEditText())
            uiKeyboardView.visibility = View.VISIBLE
            field.getEditText().requestFocus()


        }

    }
    private fun connexion(view: View) {

    }

}