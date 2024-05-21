package com.b3g.fawri.minibank.core.bases

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.b3g.fawri.minibank.R

abstract class BaseActivities : AppCompatActivity() {

    lateinit var context: Activity

    protected fun init(activity: Activity) {
        context = activity
    }

    override fun onResume() {
        super.onResume()
        context = this
    }
    fun startLoading(activity: Activity) {
        activity.findViewById<ViewGroup>(R.id.loader)?.visibility = View.VISIBLE
    }
    fun stopLoading(activity: Activity) {
        activity.findViewById<ViewGroup>(R.id.loader)?.visibility = View.GONE
    }


}
