package com.padcmyanmar.padcx.padc_x_travelapp_mtkm.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.mvp.views.TourDetailView

interface TourDetailPresenter:BaseTourPresenter<TourDetailView> {


    fun getTourbyName(tourName: String)

}