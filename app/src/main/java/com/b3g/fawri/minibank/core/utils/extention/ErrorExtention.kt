package com.b3g.fawri.minibank.core.utils.extention

import android.content.Context
import com.b3g.fawri.minibank.R
import com.b3g.fawri.minibank.core.utils.errors.DataError
import com.b3g.fawri.minibank.core.utils.errors.RootError
import com.b3g.fawri.minibank.core.utils.errors.ValidationError

fun RootError.asString(context: Context):String
{
   return when(this)
    {
        DataError.Local.SYSTEM -> context.getString(R.string.error_system)
        DataError.Network.NO_INTERNET ->  context.getString(R.string.error_no_internet)
        DataError.Network.AUTH_FAILED ->  context.getString(R.string.error_auth_failed)
        DataError.Network.FORBIDEN ->  context.getString(R.string.error_forbiden)
        DataError.Network.SERVER_ERROR ->  context.getString(R.string.error_server)
        ValidationError.PasswordError.EMPTY ->  context.getString(R.string.error_password_empty)
        ValidationError.UserIdError.EMPTY ->  context.getString(R.string.error_user_num_empty)
    }
}
