package com.anliban.copyprint.data.db.mapper

import com.anliban.copyprint.data.db.entity.CopyEntityImpl
import com.anliban.copyprint.model.Copy

fun CopyEntityImpl.toCopy() = Copy(id = id, text = text, createdAt = createdAt)

fun List<CopyEntityImpl>.toCopyList() = this.map { it.toCopy() }