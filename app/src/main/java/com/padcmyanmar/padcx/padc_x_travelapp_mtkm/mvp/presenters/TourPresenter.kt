package com.padcmyanmar.padcx.padc_x_travelapp_mtkm.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.delegates.TourItemDelegate
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.mvp.views.TourView

interface TourPresenter:BaseTourPresenter<TourView> , TourItemDelegate {
    fun onSwipeFresh(lifecycleOwner: LifecycleOwner)
    fun onUiReady(lifecycleOwner: LifecycleOwner)
}