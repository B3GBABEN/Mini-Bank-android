package com.b3g.fawri.minibank.activities

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.b3g.fawri.minibank.R
import com.b3g.fawri.minibank.widgets.keyboard.CustomKeyboard

class LoginActivity : AppCompatActivity() {
    private lateinit var uiClientId: EditText
    private lateinit var uiPassword: EditText
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
        noFocusableEditTextClickAction(uiClientId)
        noFocusableEditTextClickAction(uiPassword)
        uiConnexion.setOnClickListener { connexion(it) }
    }

    private fun noFocusableEditTextClickAction(field: EditText) {
        field.setOnClickListener {
            clearSelection()
            field.isSelected = true
            uiKeyboardView.setEditText(field)
            uiKeyboardView.visibility = View.VISIBLE
        }

    }
    private fun connexion(view: View) {

    }

}