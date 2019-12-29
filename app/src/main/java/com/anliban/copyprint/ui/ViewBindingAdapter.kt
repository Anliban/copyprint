package com.anliban.copyprint.ui

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.paging.PagedList
import androidx.recyclerview.widget.RecyclerView
import com.anliban.copyprint.model.Copy

@BindingAdapter("main_submit")
fun mainSubmit(recyclerView: RecyclerView, items: PagedList<Copy>?) {
    items?.let { (recyclerView.adapter as MainAdapter).submitList(it) }
}

@BindingAdapter(value = ["longClickCopy", "longClickCopyValue"], requireAll = true)
fun View.bindItemOnLongClick(listener: MainEventListener?, item: Copy?) {
    setOnLongClickListener {
        item?.let {
            listener?.onItemLongClick(it)
            return@setOnLongClickListener true
        }
        return@setOnLongClickListener false
    }
}