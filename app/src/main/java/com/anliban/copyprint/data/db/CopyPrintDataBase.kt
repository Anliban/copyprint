package com.anliban.copyprint.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.anliban.copyprint.data.db.dao.CopyDao
import com.anliban.copyprint.data.db.entity.CopyEntityImpl

@Database(
    entities = [
        CopyEntityImpl::class
    ], version = 1
)
abstract class CopyPrintDataBase : RoomDatabase() {
    abstract fun copyDao(): CopyDao

    companion object {

        // For Singleton instantiation
        @Volatile
        private var instance: CopyPrintDataBase? = null

        fun getInstance(context: Context): CopyPrintDataBase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        // Create and pre-populate the database. See this article for more details:
        // https://medium.com/google-developers/7-pro-tips-for-room-fbadea4bfbd1#4785
        private fun buildDatabase(context: Context): CopyPrintDataBase {
            return Room.databaseBuilder(context, CopyPrintDataBase::class.java, "copyprint-db")
                /*.addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        val request = OneTimeWorkRequestBuilder<SeedDatabaseWorker>().build()
                        WorkManager.getInstance(context).enqueue(request)
                    }
                })*/
                .build()
        }
    }
}