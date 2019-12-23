package com.anliban.copyprint.domain

import com.anliban.copyprint.data.db.dao.CopyDao
import com.anliban.copyprint.data.db.mapper.toCopyList
import com.anliban.copyprint.model.Copy
import javax.inject.Inject

interface MainRepository {
    fun copyList(): List<Copy>
}

class MainRepositoryImpl constructor(
    private val copyDao: CopyDao
) : MainRepository {

    override fun copyList(): List<Copy> {
        return copyDao.getCopyAll().toCopyList()
    }
}