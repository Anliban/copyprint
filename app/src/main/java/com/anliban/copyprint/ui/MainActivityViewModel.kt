package com.anliban.copyprint.ui

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.anliban.copyprint.base.BaseViewModel
import com.anliban.copyprint.domain.MainUseCase
import com.anliban.copyprint.model.Copy
import com.anliban.copyprint.util.ClipboardProvider
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    useCase: MainUseCase,
    private val clipboardProvider: ClipboardProvider
) : BaseViewModel(), MainEventListener {

    private val pagedConfig = PagedList.Config.Builder()
        .setPageSize(20)
        .setEnablePlaceholders(true)
        .build()

    val copyList: LiveData<PagedList<Copy>> = useCase.copyList(pagedConfig)

    override fun onClick(copy: Copy) {
        clipboardProvider.copy(copy.text)
    }

    fun refreshList() {
        copyList.value?.dataSource?.invalidate()
    }
}

interface MainEventListener {

    fun onClick(copy: Copy)
}