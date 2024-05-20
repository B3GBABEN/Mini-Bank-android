package com.b3g.fawri.minibank.presentation.screens.Comptes


/*import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.b3g.fawri.minibank.R
import com.b3g.fawri.minibank.api.models.Account
import kotlinx.android.main.item_compte.view.*

class AccountPagerAdapter(
    private val accounts: List<Account>,
    private val onAccountSelected: (Account) -> Unit
) : RecyclerView.Adapter<AccountPagerAdapter.AccountViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_compte, parent, false)
        return AccountViewHolder(view)
    }

    override fun onBindViewHolder(holder: AccountViewHolder, position: Int) {
        holder.bind(accounts[position])
    }

    override fun getItemCount(): Int = accounts.size

    inner class AccountViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(account: Account) {
            itemView.text_account_number.text = account.accountNumber
            itemView.text_balance.text = "${account.balance} MAD"
            itemView.text_description.text = account.description
            itemView.text_amount.text = account.amount

            itemView.setOnClickListener {
                onAccountSelected(account)
            }
        }
    }
}
*/