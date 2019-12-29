package com.anliban.copyprint.domain

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.anliban.copyprint.data.db.entity.CopyEntityImpl
import com.anliban.copyprint.data.db.mapper.toCopy
import com.anliban.copyprint.model.Copy

class MainUseCase constructor(
    private val repository: MainRepository
) {

    fun copyList(config: PagedList.Config): LiveData<PagedList<Copy>> {
        return LivePagedListBuilder(
            repository.copyList().map(CopyEntityImpl::toCopy),
            config
        ).build()
    }
}