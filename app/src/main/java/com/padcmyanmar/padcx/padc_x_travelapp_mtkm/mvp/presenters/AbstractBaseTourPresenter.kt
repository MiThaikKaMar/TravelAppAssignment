package com.padcmyanmar.padcx.padc_x_travelapp_mtkm.mvp.presenters

import androidx.lifecycle.ViewModel
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.mvp.views.BaseView


abstract class AbstractBaseTourPresenter<T: BaseView>:BaseTourPresenter<T>, ViewModel() {
    var mView:T? = null
    override fun initPresenter(view: T) {
        mView=view
    }


}