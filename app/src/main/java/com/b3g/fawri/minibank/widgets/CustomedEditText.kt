package com.b3g.fawri.minibank.widgets

import android.content.Context
import android.text.InputType
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import androidx.appcompat.widget.LinearLayoutCompat
import com.b3g.fawri.minibank.R

class CustomedEditText : LinearLayoutCompat {
    private lateinit var root: LinearLayoutCompat
    private lateinit var editText: EditText
    private var selected = false
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
        root = LayoutInflater.from(context).inflate(R.layout.login_edittext, this, false) as LinearLayoutCompat
        addView(root, 0)
        findViews()
        clearViews()
        setupAttrs(attrs)
        setupClickListener()
    }


    private fun setupAttrs(attrs: AttributeSet?) {
        if (attrs != null) {
            try {
                val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomedEditText)
                val hint = typedArray.getString(R.styleable.CustomedEditText_hint)
                editText.hint = hint
                val isPassword = typedArray.getBoolean(R.styleable.CustomedEditText_isPassword, false)
                editText.inputType = if (isPassword) InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD else InputType.TYPE_CLASS_TEXT
                updateUI()
                typedArray.recycle()
            } catch (e: Exception) {
                println("Custom Edit Text Exception ERROR (init) $e.message")
            }
        }

    }


    private fun findViews() {
        editText = root.findViewById(R.id.editText)
    }
    fun getEditText(): EditText {
        return editText
    }
    override fun setSelected(selected: Boolean) {
        this.selected = selected
        updateUI()
    }
    private fun updateUI() {
        root.setBackgroundResource(if (selected) R.drawable.selected_edittext else 0)
        root.invalidate()
    }
    private fun setupClickListener() {
        editText.setOnClickListener { v -> callOnClick() }
        editText.isClickable = true
    }
    private fun clearViews() {
        editText.setHint("")
    }
}