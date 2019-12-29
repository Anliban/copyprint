package com.anliban.copyprint.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagedList
import com.anliban.copyprint.base.BaseViewModel
import com.anliban.copyprint.base.ClickListener
import com.anliban.copyprint.domain.MainUseCase
import com.anliban.copyprint.model.Copy
import com.anliban.copyprint.util.ClipboardProvider
import com.anliban.copyprint.util.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val useCase: MainUseCase,
    private val clipboardProvider: ClipboardProvider
) : BaseViewModel(), MainEventListener {

    private val pagedConfig = PagedList.Config.Builder()
        .setPageSize(20)
        .setEnablePlaceholders(true)
        .build()

    val copyList: LiveData<PagedList<Copy>> = useCase.copyList(pagedConfig)

    private val _openToDeleteDialog = SingleLiveEvent<Copy>()
    val openToDeleteDialog: LiveData<Copy>
        get() = _openToDeleteDialog

    override fun onClick(copy: Copy) {
        clipboardProvider.copy(copy.text)
    }

    override fun onItemLongClick(item: Copy) {
        _openToDeleteDialog.value = item
    }

    fun refreshList() {
        copyList.value?.dataSource?.invalidate()
    }

    fun delete(item: Copy) {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.delete(item)

            launch(Dispatchers.Main) {
                refreshList()
            }
        }
    }
}

interface MainEventListener : ClickListener {

    fun onClick(copy: Copy)

    fun onItemLongClick(item: Copy)

}