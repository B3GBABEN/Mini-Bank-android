
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.b3g.fawri.minibank.databinding.NavDrawerItemBinding

data class NavDrawerItem(val icon: Int, val title: String)

class NavDrawerAdapter(private val items: List<NavDrawerItem>, private val listener: OnItemClickListener) :
    RecyclerView.Adapter<NavDrawerAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    inner class ViewHolder(private val binding: NavDrawerItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: NavDrawerItem) {
            binding.icon.setImageResource(item.icon)
            binding.title.text = item.title
            binding.root.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = NavDrawerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}
