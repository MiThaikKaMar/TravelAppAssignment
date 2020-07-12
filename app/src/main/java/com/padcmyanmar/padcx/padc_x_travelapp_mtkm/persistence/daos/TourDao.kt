package com.padcmyanmar.padcx.padc_x_travelapp_mtkm.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.data.vos.TourVO

@Dao
interface TourDao {
    @Query("SELECT * FROM tour")
    fun getAllTour(): LiveData<List<TourVO>>

    @Query("SELECT * FROM tour WHERE name = :noteId")
    fun getTourByName(noteId: String) : LiveData<TourVO>

    @Query("DELETE FROM tour")
    fun deleteAll()

    @Delete
    fun deleteTour(note: TourVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTour(noteVO: TourVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTour(news: List<TourVO>)
}