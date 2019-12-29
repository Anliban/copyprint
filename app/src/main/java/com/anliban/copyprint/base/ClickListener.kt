package com.anliban.copyprint.base

interface ClickListener {
    fun <T> onItemLongClick(item: T) = Unit
}