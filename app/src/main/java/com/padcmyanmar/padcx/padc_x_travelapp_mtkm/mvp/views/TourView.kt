package com.padcmyanmar.padcx.padc_x_travelapp_mtkm.mvp.views

import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.data.vos.TourVO

interface TourView : BaseView {
    fun displayTourList(tourList : List<TourVO>)
    fun enableSwipeRefresh()
    fun disableSwipeRefresh()
    fun showEmptyView()
    fun hideEmptyView()
    fun navigateToDetail(tourName : String)
}