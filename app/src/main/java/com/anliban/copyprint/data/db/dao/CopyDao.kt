package com.anliban.copyprint.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.anliban.copyprint.data.db.entity.CopyEntityImpl

@Dao
interface CopyDao {

    @Query("SELECT * from copy")
    fun getCopyAll(): List<CopyEntityImpl>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(copy: CopyEntityImpl)
}