package com.anliban.copyprint.data.db.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.anliban.copyprint.data.db.entity.CopyEntityImpl

@Dao
interface CopyDao {

    @Query("SELECT * from copy order by id DESC")
    fun getCopyAll(): DataSource.Factory<Int, CopyEntityImpl>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(copy: CopyEntityImpl)
}