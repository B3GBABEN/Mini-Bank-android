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
import com.b3g.fawri.minibank.callbacks.OnItemClickListener


class CustomKeyboard: LinearLayoutCompat {

    enum class KEYBOARD_BUTTON_ACTION {
        CLEAR,
        DELETE_LAST,
    }

    private lateinit var editText: EditText

    fun setEditText(editText: EditText) {
        this.editText = editText
    }
    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        LayoutInflater.from(context).inflate(R.layout.keyboard_view, this, true)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context, 3)

        val itemClickListener = object : OnItemClickListener<String> {
            override fun onItemClicked(data: String) {
                when (data) {
                    KEYBOARD_BUTTON_ACTION.CLEAR.toString() -> clearAll()
                    KEYBOARD_BUTTON_ACTION.DELETE_LAST.toString() -> deleteLastCharacter()
                    else -> write(data)
                }
            }
        }

        val adapter = KeyboardAdapter(itemClickListener)
        recyclerView.adapter = adapter
    }


    private fun write(number: String) {
        editText.let {
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
        editText.setText("")
    }
}