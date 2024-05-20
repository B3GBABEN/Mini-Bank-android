package com.b3g.fawri.minibank.presentation.screens.Transactions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.b3g.fawri.minibank.R
import com.b3g.fawri.minibank.api.models.Transaction

class TransactionAdapter(private val transactions: List<Transaction>) :
    RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.transaction_item, parent, false)
        return TransactionViewHolder(view)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val transaction = transactions[position]
        holder.bind(transaction)
    }

    override fun getItemCount(): Int {
        return transactions.size
    }

    class TransactionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(transaction: Transaction) {
            itemView.findViewById<TextView>(R.id.text_date).text = transaction.date
            itemView.findViewById<TextView>(R.id.text_description).text = transaction.description
            itemView.findViewById<TextView>(R.id.text_amount).text = transaction.amount.toString()
        }
    }
}
