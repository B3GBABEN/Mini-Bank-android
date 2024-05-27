package com.b3g.fawri.minibank.presentation.screens.home
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.b3g.fawri.minibank.databinding.CardItemBinding

class CardAdapter(private val cardList: List<CardItem>) : RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    class CardViewHolder(val binding: CardItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = CardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val cardItem = cardList[position]
        with(holder.binding) {
            imageCard.setImageResource(cardItem.imageResId)
            MiniBankText.text = cardItem.miniBankText
            numAccount.text = cardItem.cardNumberText
            currentAccount.text = cardItem.accountTypeText
            solde.text = cardItem.balanceText
            switchButton.setImageResource(cardItem.switchImageResId)
        }
    }

    override fun getItemCount() = cardList.size
}

data class CardItem(
    val imageResId: Int,
    val miniBankText: String,
    val cardNumberText: String,
    val accountTypeText: String,
    val balanceText: String,
    val switchImageResId: Int
)
