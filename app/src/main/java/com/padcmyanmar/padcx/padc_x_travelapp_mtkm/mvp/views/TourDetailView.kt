package com.padcmyanmar.padcx.padc_x_travelapp_mtkm.mvp.views

import androidx.lifecycle.LiveData
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.data.vos.TourVO

interface TourDetailView:BaseView {
    fun displayNewsDetails(tour: LiveData<TourVO>)
}