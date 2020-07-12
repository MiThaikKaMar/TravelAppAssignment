package com.padcmyanmar.padcx.padc_x_travelapp_mtkm.workers

import android.content.Context
import androidx.work.WorkerParameters

class GetTourWorker(context: Context, workerParams: WorkerParameters) :
    BaseWorker(context, workerParams) {

    override fun doWork(): Result {
        var result = Result.failure()

        mTourModel.getAllNewsFromApiAndSaveToDatabase(
            onSuccess = {
                result = Result.success()
            },
            onError = {
                result = Result.failure()
            }
        )
        return result
    }
}