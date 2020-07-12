package com.padcmyanmar.padcx.padc_x_travelapp_mtkm.data.models

import androidx.lifecycle.LiveData
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.data.vos.TourVO
import io.reactivex.Observable


interface TourModel {

    fun getAllTour(onError: (String) -> Unit) :LiveData<List<TourVO>>

    fun getAllNewsFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)

    fun getTourByName(dataName: String):LiveData<TourVO>
}