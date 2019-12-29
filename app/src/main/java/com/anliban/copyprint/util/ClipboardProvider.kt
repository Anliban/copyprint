package com.anliban.copyprint.util

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context

class ClipboardProvider(context: Context) {

    private companion object {
        private const val CLIP_INDEX = 0
    }

    private val manager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

    private lateinit var listener: ClipboardManager.OnPrimaryClipChangedListener

    fun bindDetect(action: (String) -> Unit) {
        if (!::listener.isInitialized) {
            val listener = ClipboardManager.OnPrimaryClipChangedListener {
                val data = manager.primaryClip
                val text = data?.getItemAt(CLIP_INDEX)?.text?.trim()
                val label = data?.description?.label

                if (label != CLIP_COPY_LABEL) {
                    if (!text.isNullOrEmpty()) {
                        action(text.toString())
                    }
                }
            }
            this.listener = listener
            manager.addPrimaryClipChangedListener(listener)
        } else throw IllegalStateException("Already Initialized Clipboard ChangedListener!")
    }

    fun unBindDetect() {
        if (::listener.isInitialized) {
            manager.removePrimaryClipChangedListener(listener)
        }
    }

    fun copy(text: String) {
        manager.setPrimaryClip(ClipData.newPlainText(CLIP_COPY_LABEL, text))
    }
}