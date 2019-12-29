package com.anliban.copyprint.domain

import androidx.paging.DataSource
import androidx.paging.PagedList
import com.anliban.copyprint.data.db.dao.CopyDao
import com.anliban.copyprint.data.db.entity.CopyEntityImpl
import com.anliban.copyprint.data.db.mapper.toCopy
import com.anliban.copyprint.data.db.mapper.toCopyEntity
import com.anliban.copyprint.data.db.mapper.toCopyList
import com.anliban.copyprint.model.Copy
import javax.inject.Inject

interface MainRepository {
    fun copyList(): DataSource.Factory<Int, CopyEntityImpl>

    suspend fun delete(copy: Copy)
}

class MainRepositoryImpl constructor(
    private val copyDao: CopyDao
) : MainRepository {

    override fun copyList(): DataSource.Factory<Int, CopyEntityImpl> {
        return copyDao.getCopyAll()
    }

    override suspend fun delete(copy: Copy) {
        copyDao.delete(copy.toCopyEntity())
    }
}