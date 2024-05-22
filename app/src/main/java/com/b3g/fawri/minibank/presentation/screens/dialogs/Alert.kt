package com.b3g.fawri.minibank.presentation.screens.dialogs
import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import cn.pedant.SweetAlert.SweetAlertDialog
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
        onCancel: (() -> Unit)? = null,
        backgroundColor: Int = R.color.keyboard_button_background,
      //  iconType : Int= SweetAlertDialog.WARNING_TYPE
    ) {

        binding = CustomAlertDialogBinding.inflate(LayoutInflater.from(context))
        binding.textTitle.text = title
        binding.textMessage.text = message

        val dialog = SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
        dialog.titleText = title
        dialog.contentText = message
        dialog.setCancelable(cancellable)
        dialog.setConfirmButton(context.getString(R.string.ok)) { sweetAlertDialog ->
            sweetAlertDialog.dismissWithAnimation()
            onConfirm?.invoke()
        }

        if (onCancel != null) {
            dialog.setCancelButton(context.getString(R.string.cancel)) { sweetAlertDialog ->
                sweetAlertDialog.dismissWithAnimation()
                onCancel.invoke()
            }
        }


        dialog.show()
        dialog.window?.setBackgroundDrawableResource(backgroundColor)

    }
}
