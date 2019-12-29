package com.anliban.copyprint.base.adapter

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import com.anliban.copyprint.R

class GeryDividerItemDecoration(
    context: Context,
    orientation: Int = VERTICAL
) : DividerItemDecoration(context, orientation) {

    init {
        val dividerDrawable = ContextCompat.getDrawable(context, R.drawable.divider_grey)
        checkNotNull(dividerDrawable)
        setDrawable(dividerDrawable)
    }

}