package com.anliban.copyprint.util

import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.anliban.copyprint.R
import com.anliban.copyprint.ui.MainActivity

fun Context.alert(
    title: String?,
    message: String?,
    action: () -> Unit
): AlertDialog {
    return AlertDialog.Builder(this).apply {
        setTitle(title)
        setMessage(message)
        setPositiveButton(
            R.string.alert_positive
        ) { _, _ ->
            action()
        }

        setNegativeButton(R.string.alert_negative) { _, _ ->

        }
    }.show()
}

fun MainActivity.deleteDialog(action: () -> Unit) {
    alert(getString(R.string.alert_delete_title), getString(R.string.alert_delete_message), action)
}