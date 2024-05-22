package com.b3g.fawri.minibank.presentation.popups

import android.content.Context
import android.view.View
import androidx.appcompat.widget.PopupMenu
import com.b3g.fawri.minibank.R

object Popup {
    fun showLanguageSelectionPopup(context: Context, anchorView: View) {
        val popupMenu = PopupMenu(context, anchorView)
        popupMenu.menuInflater.inflate(R.menu.language_menu, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_english -> {
                    true
                }
                R.id.menu_french -> {
                    true
                }
                else -> false
            }
        }

        popupMenu.show()
    }
}
