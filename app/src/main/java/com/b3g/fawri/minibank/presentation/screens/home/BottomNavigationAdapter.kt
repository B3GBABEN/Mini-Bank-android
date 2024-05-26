package com.b3g.fawri.minibank.presentation.screens.home


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.b3g.fawri.minibank.databinding.ItemBottomNavigationBinding

data class NavigationItem(val iconResId: Int, val title: String)

class BottomNavigationAdapter(
    private val items: List<NavigationItem>,
    private val itemClickListener: (NavigationItem) -> Unit
) : RecyclerView.Adapter<BottomNavigationAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemBottomNavigationBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: NavigationItem, clickListener: (NavigationItem) -> Unit) {
            binding.navigationItemIcon.setImageResource(item.iconResId)
            binding.navigationItemTitle.text = item.title
            binding.root.setOnClickListener { clickListener(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBottomNavigationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], itemClickListener)
    }

    override fun getItemCount() = items.size
}
