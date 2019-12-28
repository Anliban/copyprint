package com.anliban.copyprint.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "copy")
data class CopyEntityImpl(
    @PrimaryKey(autoGenerate = true) override var id: Int,
    @ColumnInfo(name = "copy_text") override var text: String,
    @ColumnInfo(name = "copy_created_at") override var createdAt: Long
) : CopyEntity