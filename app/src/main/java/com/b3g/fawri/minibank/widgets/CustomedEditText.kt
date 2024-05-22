package com.b3g.fawri.minibank.widgets

import android.content.Context
import android.text.InputType
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.widget.LinearLayoutCompat
import com.b3g.fawri.minibank.R
import com.b3g.fawri.minibank.databinding.LoginEdittextBinding

class CustomedEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayoutCompat(context, attrs, defStyleAttr) {

    private val binding: LoginEdittextBinding =
        LoginEdittextBinding.inflate(LayoutInflater.from(context), this, true)
    private var selected = false

    init {
        setupAttrs(attrs)
        setupClickListener()
    }

    private fun setupAttrs(attrs: AttributeSet?) {
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.CustomedEditText)
            binding.editText.hint = typedArray.getString(R.styleable.CustomedEditText_hint)
            val isPassword = typedArray.getBoolean(R.styleable.CustomedEditText_isPassword, false)
            binding.editText.inputType = if (isPassword) {
                InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            } else {
                InputType.TYPE_CLASS_TEXT
            }
            updateUI()
            typedArray.recycle()
        }
    }

    override fun setSelected(selected: Boolean) {
        this.selected = selected
        updateUI()
    }

    private fun updateUI() {
        binding.root.setBackgroundResource(if (selected) R.drawable.button_keyboard else 0)
        binding.root.invalidate()
    }

    private fun setupClickListener() {
        binding.editText.setOnClickListener {
            setSelected(true)
            callOnClick()
        }
        binding.editText.isClickable = true
    }

    fun getEditText() = binding.editText

    fun getText(): String = binding.editText.text.toString()
}
