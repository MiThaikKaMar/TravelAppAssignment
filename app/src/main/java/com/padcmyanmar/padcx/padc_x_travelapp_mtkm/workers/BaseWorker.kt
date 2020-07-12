package com.padcmyanmar.padcx.padc_x_travelapp_mtkm.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.data.models.TourModel
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.data.models.TourModelImpl

abstract class BaseWorker(context: Context, workerParams: WorkerParameters)
    : Worker(context, workerParams) {
    val mTourModel :TourModel = TourModelImpl
}