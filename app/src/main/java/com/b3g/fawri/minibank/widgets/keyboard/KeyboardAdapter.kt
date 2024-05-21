import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.b3g.fawri.minibank.R
import com.b3g.fawri.minibank.callbacks.OnItemClickListener
import com.b3g.fawri.minibank.widgets.keyboard.CustomKeyboard

class KeyboardAdapter(private val listener: OnItemClickListener<String>) :
    RecyclerView.Adapter<KeyboardAdapter.ViewHolder>() {

    private lateinit var numbers: ArrayList<String>

    init {
        randomNumbers()
    }

    private fun randomNumbers() {
        numbers = ArrayList()
        for (i in 0 until 10) {
            numbers.add(i.toString())
        }
        numbers.shuffle()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.keyboard_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var value = ""

        when (position) {
            9 -> {
                holder.updateVisibility(false)
                holder.uiImage.setImageResource(R.drawable.ic_arrow_back)
                value = CustomKeyboard.KEYBOARD_BUTTON_ACTION.CLEAR.toString()
            }
            11 -> {
                holder.updateVisibility(false)
                holder.uiImage.setImageResource(R.drawable.ic_remove)
                value = CustomKeyboard.KEYBOARD_BUTTON_ACTION.DELETE_LAST.toString()
            }
            else -> {
                if (numbers.isNotEmpty()) {
                    value = numbers.removeAt(0)
                }
                holder.updateVisibility(true)
                holder.uiText.text = value
            }
        }

        holder.itemView.setOnClickListener {
            listener.onItemClicked(value)
        }
    }

    override fun getItemCount(): Int {
        return 12
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val uiText: TextView = itemView.findViewById(R.id.text)
        val uiImage: ImageView = itemView.findViewById(R.id.image)

        init {
            uiText.text = ""
            uiImage.setImageResource(android.R.color.transparent)
        }

        fun updateVisibility(isText: Boolean) {
            itemView.setBackgroundResource(if (isText) R.drawable.button_keyboard else R.drawable.clear_button_keyboard)
            uiText.visibility = if (isText) View.VISIBLE else View.GONE
            uiImage.visibility = if (isText) View.GONE else View.VISIBLE
        }
    }
}
