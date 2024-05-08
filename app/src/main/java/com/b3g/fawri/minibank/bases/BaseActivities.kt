package com.b3g.fawri.minibank.bases

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity

open class BaseActivities : AppCompatActivity() {

    lateinit var context: Activity

    protected fun init(activity: Activity) {
        context = activity
    }

    override fun onResume() {
        super.onResume()
        context = this
    }
}
