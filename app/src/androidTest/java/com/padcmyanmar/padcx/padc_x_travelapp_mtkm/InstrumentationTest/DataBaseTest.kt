package com.padcmyanmar.padcx.padc_x_travelapp_mtkm.InstrumentationTest

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.data.vos.TourVO
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.persistence.daos.TourDao
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.persistence.db.TourDB
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class DataBaseTest {
    private lateinit var mTourDao : TourDao
    private lateinit var db : TourDB

    @Before
    fun setUpDB(){

        val context= ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context,TourDB::class.java).build()
        mTourDao=db.tourDao()
    }

    @After
    fun closeDB(){
        db.close()
    }

    @Test
    fun databaseTest(){
        val tourOne = TourVO()
        tourOne.name="Singapore"
        tourOne.location="AAAAAAAAAAAA"
        tourOne.averageRating="4.5"


        mTourDao.insertTour(tourOne)
        assert(mTourDao.getTourByName(tourOne.name).value?.name == tourOne.name)
    }
}