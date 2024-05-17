package com.b3g.fawri.minibank.ui.Transactions

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.b3g.fawri.minibank.R
import com.b3g.fawri.minibank.api.models.Transaction
/*
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
*/
import androidx.viewpager2.widget.ViewPager2

import com.b3g.fawri.minibank.api.models.Account
import com.b3g.fawri.minibank.widgets.ARIndicatorView


class TransactionActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewPager: ViewPager2
    private lateinit var indicatorView: ARIndicatorView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction)

        val transactions = getTransactions() // Méthode pour obtenir la liste des transactions
        val accounts = getAccounts() // Méthode pour obtenir la liste des comptes

        recyclerView = findViewById(R.id.recycler_view_transactions)
        recyclerView.layoutManager = LinearLayoutManager(this)

       /* viewPager = findViewById(R.id.accounts)
        indicatorView = findViewById(R.id.accounts_indicator)

        viewPager.adapter = AccountAdapter(accounts) { account ->
            val accountTransactions = transactions.filter { it.accountId == account.id }
            updateTransactions(accountTransactions)
        }

        indicatorView.setViewPager(viewPager)*/

        // Initialiser les transactions du premier compte
        if (accounts.isNotEmpty()) {
            val initialAccountTransactions = transactions.filter { it.accountId == accounts.first().id }
            updateTransactions(initialAccountTransactions)
        }
    }

    private fun getTransactions(): List<Transaction> {
        // Implémentez cette méthode pour obtenir la liste des transactions
        // Exemple simulé de données :
        return listOf(
            Transaction("2023-05-14", "Transaction 1", 100.0, 1),
            Transaction("2023-05-15", "Transaction 2", 200.0, 1),
            Transaction("2023-05-16", "Transaction 3", 150.0, 2),
            // Ajoutez d'autres transactions
        )
    }

    private fun getAccounts(): List<Account> {
        // Implémentez cette méthode pour obtenir la liste des comptes
        // Exemple simulé de données :
        return listOf(
            Account(1, "123456", "1000.0", "Description 1", "Amount 1"),
            Account(2, "654321", "2000.0", "Description 2", "Amount 2")
        )
    }

    private fun updateTransactions(transactions: List<Transaction>) {
        val groupedTransactions = transactions.groupBy { it.date }
        val sortedTransactions = groupedTransactions.toList().sortedByDescending { it.first }
        val flattenedTransactions = sortedTransactions.flatMap { (_, transactions) -> transactions }

        recyclerView.adapter = TransactionAdapter(flattenedTransactions)
    }
}
