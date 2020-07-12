package com.padcmyanmar.padcx.padc_x_travelapp_mtkm.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.data.models.TourModel
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.data.models.TourModelImpl
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.mvp.views.TourView

class TourPresenterImpl :TourPresenter, AbstractBaseTourPresenter<TourView>() {

    private val mTourModel : TourModel=TourModelImpl
    override fun onSwipeFresh(lifecycleOwner: LifecycleOwner) {
        getTourData(lifecycleOwner)
    }

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        getTourData(lifecycleOwner)
    }

    override fun onTapTourItem(dataName: String) {
        mView?.navigateToDetail(dataName)
    }

    private fun getTourData(lifecycleOwner: LifecycleOwner){
        mView?.enableSwipeRefresh()
        mTourModel.getAllTour(
            onError = {
                mView?.disableSwipeRefresh()
                mView?.showEmptyView()
                mView?.showErrorMessage(it)
            }).observe(lifecycleOwner, Observer {
            mView?.disableSwipeRefresh()
            if(it.isEmpty()){
                mView?.showEmptyView()
            }else{
                mView?.hideEmptyView()
                mView?.displayTourList(it)
            }
        })
    }



}