package com.robosoftin.tvdemo.utils

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import androidx.appcompat.widget.AppCompatTextView
import com.robosoftin.tvdemo.R

class Loading(mContext: Context) {

    private var mDialog: Dialog? = Dialog(mContext)
    private var mContext: Context? = mContext

    fun show(message: String?) {
        if ((mContext as Activity).isFinishing || (mContext as Activity).isDestroyed) {
            return
        }
        try {
            mDialog?.window?.requestFeature(Window.FEATURE_NO_TITLE);
            mDialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            val view: View =
                LayoutInflater.from(mContext)
                    .inflate(R.layout.layout_custom_loading, null)
            val tvMessage = view.findViewById<AppCompatTextView>(R.id.tv_message)
            tvMessage.text = message
            mDialog?.setContentView(view)
            mDialog?.window?.setLayout(-1, -2)
            mDialog?.setCancelable(false)
            mDialog?.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun dismiss() {
        if (mDialog != null && mDialog?.isShowing() == true) {
            mDialog?.dismiss()
        }
    }
}
