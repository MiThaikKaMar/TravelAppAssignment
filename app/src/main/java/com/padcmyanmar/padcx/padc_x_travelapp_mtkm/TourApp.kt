package com.padcmyanmar.padcx.padc_x_travelapp_mtkm

import android.app.Application
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.data.models.TourModelImpl
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.workers.GetTourWorker

class TourApp :Application() {
    override fun onCreate() {
        super.onCreate()

        TourModelImpl.initDatabase(applicationContext)
        getTourOneTime()

    }
    private fun getTourOneTime(){
        val getEventsWorkRequest = OneTimeWorkRequest
            .Builder(GetTourWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getEventsWorkRequest)
    }
}