package com.anliban.copyprint.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.anliban.copyprint.databinding.ItemMainBinding
import com.anliban.copyprint.model.Copy

class MainAdapter(
    private val lifecycleOwner: LifecycleOwner,
    private val eventListener: MainEventListener
) : ListAdapter<Copy, MainViewHolder>(DiffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding, lifecycleOwner, eventListener)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class MainViewHolder(
    private val binding: ItemMainBinding,
    private val lifecycleOwner: LifecycleOwner,
    private val eventListener: MainEventListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Copy) {
        binding.item = item
        binding.lifecycleOwner = lifecycleOwner
        binding.listener = eventListener
        binding.executePendingBindings()
    }
}

val DiffUtil = object : DiffUtil.ItemCallback<Copy>() {
    override fun areItemsTheSame(oldItem: Copy, newItem: Copy): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Copy, newItem: Copy): Boolean {
        return oldItem == newItem
    }

}