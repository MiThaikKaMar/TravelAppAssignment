package com.padcmyanmar.padcx.padc_x_travelapp_mtkm.persistence.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.data.vos.TourVO
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.persistence.daos.TourDao

@Database(entities = [TourVO::class], version = 1, exportSchema = false)
abstract class TourDB : RoomDatabase() {
    companion object {
        val DB_NAME = "PADC_NEWS_X.DB_M"
        var dbInstance: TourDB? = null

        fun getDBInstance(context: Context): TourDB {
            when (dbInstance) {
                null -> {
                    dbInstance = Room.databaseBuilder(context, TourDB::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }

            val i = dbInstance
            return i!!
        }
    }
    abstract fun tourDao(): TourDao
}