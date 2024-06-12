package com.b3g.fawri.minibank.presentation.navigationDrawer

import NavDrawerAdapter
import NavDrawerItem
import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.b3g.fawri.minibank.R
import com.b3g.fawri.minibank.databinding.ActivityHomeBinding
import com.b3g.fawri.minibank.databinding.ActivityLoginBinding

object MenuManager {

    fun setOnlineMenu(context: Context, binding: ActivityHomeBinding) {
        val drawerItems = listOf(
            NavDrawerItem(R.drawable.ic_activate, "Mes Comptes"),
            NavDrawerItem(R.drawable.ic_language, "Mes Virements"),
            NavDrawerItem(R.drawable.ic_activate, "Mes Cartes"),
            NavDrawerItem(R.drawable.ic_activate, "Mes Factures"),
            NavDrawerItem(R.drawable.ic_activate, "Mes Bénéficiaires"),
            NavDrawerItem(R.drawable.ic_activate, "Mon Profile"),
            NavDrawerItem(R.drawable.ic_bill, "Mon Conseiller")
        )
        binding.navRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.navRecyclerView.adapter = NavDrawerAdapter(drawerItems, context as NavDrawerAdapter.OnItemClickListener)
    }

    fun setOfflineMenu(context: Context, binding: ActivityLoginBinding) {
        val drawerItems = listOf(
            NavDrawerItem(R.drawable.ic_activate, "Activation du compte"),
            NavDrawerItem(R.drawable.ic_language, "Choix de langue"),
            NavDrawerItem(R.drawable.ic_bill, "Mention legal"),
            NavDrawerItem(R.drawable.menu_item_icon, "A propos")
        )
        binding.navRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.navRecyclerView.adapter = NavDrawerAdapter(drawerItems, context as NavDrawerAdapter.OnItemClickListener)
    }
}