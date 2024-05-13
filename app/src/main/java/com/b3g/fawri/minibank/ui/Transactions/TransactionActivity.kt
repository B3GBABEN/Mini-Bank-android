package com.b3g.fawri.minibank.ui.Transactions

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.b3g.fawri.minibank.R
import com.b3g.fawri.minibank.api.models.Transaction

class TransactionsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction)

        val transactions = getTransactions() // Méthode pour obtenir la liste des transactions

        recyclerView = findViewById(R.id.recycler_view_transactions)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val groupedTransactions = transactions.groupBy { it.date }
        val sortedTransactions = groupedTransactions.toList().sortedByDescending { it.first }
        val flattenedTransactions = sortedTransactions.flatMap { (_, transactions) -> transactions }

        recyclerView.adapter = TransactionAdapter(flattenedTransactions)
    }

    private fun getTransactions(): List<Transaction> {
        // Implémentez cette méthode pour obtenir la liste des transactions
    }
}
