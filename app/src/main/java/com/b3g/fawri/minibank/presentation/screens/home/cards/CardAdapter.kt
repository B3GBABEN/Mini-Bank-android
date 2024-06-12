package com.b3g.fawri.minibank.presentation.screens.home.cards

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.b3g.fawri.minibank.data.remote.moels.Account
import com.b3g.fawri.minibank.databinding.CardItemBinding

class CardAdapter(private var accountList: List<Account>) : RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    class CardViewHolder(val binding: CardItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = CardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val account = accountList[position]
        holder.binding.account = account
        holder.binding.executePendingBindings()
    }

    override fun getItemCount() = accountList.size

    fun setItems(items: List<Account>) {
        this.accountList = items
    }
}
