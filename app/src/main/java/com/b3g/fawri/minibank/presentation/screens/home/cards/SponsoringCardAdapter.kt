package com.b3g.fawri.minibank.presentation.screens.home.cards

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.b3g.fawri.minibank.data.remote.moels.SponsoringCard
import com.b3g.fawri.minibank.databinding.SponsoringCardItemBinding

class SponsoringCardAdapter(private var sponsoringCardList: List<SponsoringCard>) : RecyclerView.Adapter<SponsoringCardAdapter.SponsoringCardViewHolder>() {

    class SponsoringCardViewHolder(val binding: SponsoringCardItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SponsoringCardViewHolder {
        val binding = SponsoringCardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SponsoringCardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SponsoringCardViewHolder, position: Int) {
        val sponsoringCard = sponsoringCardList[position]
        holder.binding.cardImage.setImageResource(sponsoringCard.imageResId)
        holder.binding.executePendingBindings()
    }

    override fun getItemCount() = sponsoringCardList.size

    fun setItems(items: List<SponsoringCard>) {
        this.sponsoringCardList = items
    }
}
