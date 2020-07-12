package com.padcmyanmar.padcx.padc_x_travelapp_mtkm.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.activities.DetailActivity
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.data.models.TourModel
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.data.models.TourModelImpl
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.mvp.views.TourDetailView

class TourDetailPresenterImpl:TourDetailPresenter,AbstractBaseTourPresenter<TourDetailView>() {
    private val mTourModel : TourModel = TourModelImpl

    override fun getTourbyName(tourName: String) {
        //get data from database by tour name
        //mView.displayNewsDetails(tour = result)

        mView?.displayNewsDetails(
            tour = mTourModel.getTourByName(tourName)
        )
    }



}