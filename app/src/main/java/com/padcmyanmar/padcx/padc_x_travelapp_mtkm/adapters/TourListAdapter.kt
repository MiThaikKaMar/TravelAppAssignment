package com.padcmyanmar.padcx.padc_x_travelapp_mtkm.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.R
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.data.vos.TourVO
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.delegates.TourItemDelegate
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.views.viewholders.TourViewHolder

class TourListAdapter(delegate: TourItemDelegate): BaseAdapter<TourViewHolder,TourVO>(){

    val mDelegate:TourItemDelegate=delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TourViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_tour,parent,false)
        return TourViewHolder(
            view,
            mDelegate
        )
    }

}