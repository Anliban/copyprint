package com.anliban.copyprint.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.anliban.copyprint.data.db.CopyPrintDataBase.Companion.DB_VERSION
import com.anliban.copyprint.data.db.dao.CopyDao
import com.anliban.copyprint.data.db.entity.CopyEntityImpl

@Database(
    entities = [
        CopyEntityImpl::class
    ], version = DB_VERSION
)
abstract class CopyPrintDataBase : RoomDatabase() {
    abstract fun copyDao(): CopyDao

    companion object {
        const val DB_VERSION = 1

        // For Singleton instantiation
        @Volatile
        private var instance: CopyPrintDataBase? = null

        fun getInstance(context: Context): CopyPrintDataBase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): CopyPrintDataBase {
            return Room.databaseBuilder(context, CopyPrintDataBase::class.java, "copyprint-db")
                .build()
        }
    }
}