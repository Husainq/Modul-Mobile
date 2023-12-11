package com.example.belajarsqlite.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.belajarsqlite.model.Jadwal

@Database(entities = [Jadwal::class], version = 1, exportSchema = false)
abstract class JadwalDb:RoomDatabase() {
    abstract fun JadwalDAO(): JadwalDAO

    companion object {
        @Volatile
        private var INSTANCE: JadwalDb? = null

        fun getDb(context: Context): JadwalDb {
            val  tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    JadwalDb::class.java,
                    "jadwal kuliah"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}