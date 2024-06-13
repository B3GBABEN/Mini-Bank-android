package com.b3g.fawri.minibank.presentation.screens.factures

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.b3g.fawri.minibank.data.remote.moels.Facture
import com.b3g.fawri.minibank.databinding.HistoriqueFactureItemBinding

class FactureAdapter(private var factures: List<Facture>) :
    RecyclerView.Adapter<FactureAdapter.FactureViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FactureViewHolder {
        val binding = HistoriqueFactureItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return FactureViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FactureViewHolder, position: Int) {
        holder.bind(factures[position])
    }

    override fun getItemCount(): Int = factures.size

    inner class FactureViewHolder(private val binding: HistoriqueFactureItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(facture: Facture) {
            binding.facture = facture
            binding.executePendingBindings()
        }
    }

    fun updateFactures(newFactures: List<Facture>) {
        factures = newFactures
        notifyDataSetChanged()
    }
}
