package com.padcmyanmar.padcx.padc_x_travelapp_mtkm.network

import androidx.lifecycle.LiveData
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.network.responses.GetAllTourResponses
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.utils.GET_TOURS
import io.reactivex.Observable
import retrofit2.http.GET

interface TourApi {
    @GET(GET_TOURS)
    fun getAllTours()
            :Observable<GetAllTourResponses>
}