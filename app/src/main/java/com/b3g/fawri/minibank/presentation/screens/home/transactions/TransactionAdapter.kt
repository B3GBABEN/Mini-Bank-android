package com.b3g.fawri.minibank.presentation.screens.home.transactions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.b3g.fawri.minibank.databinding.TransactionDateItemBinding
import com.b3g.fawri.minibank.databinding.TransactionItemsBinding

class TransactionAdapter(private var transactionList: List<TransactionItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_DATE = 0
        private const val VIEW_TYPE_TRANSACTION = 1
    }

    override fun getItemViewType(position: Int): Int {
        return when (transactionList[position]) {
            is TransactionItem.DateHeader -> VIEW_TYPE_DATE
            is TransactionItem.TransactionDetail -> VIEW_TYPE_TRANSACTION
            else -> {0}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_DATE) {
            val binding = TransactionDateItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            DateViewHolder(binding)
        } else {
            val binding = TransactionItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            TransactionViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = transactionList[position]) {
            is TransactionItem.DateHeader -> {
                (holder as DateViewHolder).binding.date = item.date
                holder.binding.executePendingBindings()
            }
            is TransactionItem.TransactionDetail -> {
                (holder as TransactionViewHolder).binding.transaction = item.transaction
                holder.binding.executePendingBindings()

                // Set text color based on the amount
                val colorResId = if (item.transaction.amount > 0) android.R.color.holo_blue_dark else android.R.color.holo_red_dark
                holder.binding.transactionAmount.setTextColor(holder.binding.root.context.getColor(colorResId))
            }

            else -> {}
        }
    }

    override fun getItemCount() = transactionList.size

    fun setItems(items: List<TransactionItem>) {
        this.transactionList = items
        notifyDataSetChanged()
    }

    class DateViewHolder(val binding: TransactionDateItemBinding) : RecyclerView.ViewHolder(binding.root)
    class TransactionViewHolder(val binding: TransactionItemsBinding) : RecyclerView.ViewHolder(binding.root)
}
