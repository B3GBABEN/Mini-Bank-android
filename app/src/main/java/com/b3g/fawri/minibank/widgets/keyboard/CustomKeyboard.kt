package com.b3g.fawri.minibank.widgets.keyboard

import KeyboardAdapter
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.EditText
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.b3g.fawri.minibank.R
import com.b3g.fawri.minibank.interfaces.OnItemClickListener


class CustomKeyboard @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayoutCompat(context, attrs, defStyleAttr) {

    enum class KEYBOARD_BUTTON_ACTION {
        CLEAR,
        DELETE_LAST,
    }

    private var editText: EditText? = null

    fun setEditText(editText: EditText) {
        this.editText = editText
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.keyboard_view, this, true)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context, 3)
        val adapter = KeyboardAdapter(object : OnItemClickListener<String> {
          override fun onItemClicked(data: String) {
                when (data) {
                    KEYBOARD_BUTTON_ACTION.CLEAR.toString() -> clearAll()
                    KEYBOARD_BUTTON_ACTION.DELETE_LAST.toString() -> deleteLastCharacter()
                    else -> write(data)
                }
            }
        })
        recyclerView.adapter = adapter
    }

    private fun write(number: String) {
        editText?.let {
            val value = it.text.toString()
            val newValue = value + number
            it.setText(newValue)
        }
    }

    private fun deleteLastCharacter() {
        editText?.let {
            if (it.text.toString().isNotEmpty()) {
                val value = it.text.toString()
                val newValue = StringBuilder(value).deleteCharAt(value.length - 1).toString()
                it.setText(newValue)
            }
        }
    }

    private fun clearAll() {
        editText?.setText("")
    }
}