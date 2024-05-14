package com.b3g.fawri.minibank.ui.Transactions

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.b3g.fawri.minibank.R
import com.b3g.fawri.minibank.api.models.Transaction

class TransactionActivity : AppCompatActivity() {

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
        // Pour l'exemple, on génère des transactions statiques
        return listOf(
            Transaction(date = "2023-05-01", amount = 100.0, description = "Transaction 1"),
            Transaction(date = "2023-05-01", amount = 150.0, description = "Transaction 2"),
            Transaction(date = "2023-05-02", amount = 200.0, description = "Transaction 3"),
            Transaction(date = "2023-05-03", amount = 50.0, description = "Transaction 4"),
            Transaction(date = "2023-05-02", amount = 300.0, description = "Transaction 5"),
            Transaction(date = "2023-05-01", amount = 75.0, description = "Transaction 6"),
        )
    }
}
