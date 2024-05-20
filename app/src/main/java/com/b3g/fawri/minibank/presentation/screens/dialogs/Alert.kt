package com.b3g.fawri.minibank.presentation.screens.dialogs
import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import com.b3g.fawri.minibank.R
import com.b3g.fawri.minibank.databinding.CustomAlertDialogBinding
object Alert {
    private lateinit var binding: CustomAlertDialogBinding

    fun show(
        context: Context,
        title: String = "",
        message: String,
        cancellable: Boolean = true,
        onConfirm: (() -> Unit)? = null,
        onCancel: (() -> Unit)? = null
    ) {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.custom_alert_dialog, null)

        binding = CustomAlertDialogBinding.inflate(LayoutInflater.from(context))
        binding.textTitle.text = title
        binding.textMessage.text = message

        val builder = AlertDialog.Builder(context)
        builder.setView(dialogView)
            .setCancelable(cancellable)
            .setPositiveButton(R.string.ok) { dialog, _ ->
                dialog.dismiss()
                onConfirm?.invoke()
            }

        if (onCancel != null) {
            builder.setNegativeButton(R.string.cancel) { dialog, _ ->
                dialog.dismiss()
                onCancel.invoke()
            }
        }

        val dialog = builder.create()
        dialog.show()
    }
}
