package com.padcmyanmar.padcx.padc_x_travelapp_mtkm.mvp.presenters

import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.mvp.views.BaseView

interface BaseTourPresenter<T: BaseView> {
    fun initPresenter(view: T)
}