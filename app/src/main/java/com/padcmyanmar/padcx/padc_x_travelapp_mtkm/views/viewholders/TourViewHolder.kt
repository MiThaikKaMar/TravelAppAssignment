package com.padcmyanmar.padcx.padc_x_travelapp_mtkm.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.data.vos.TourVO
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.delegates.TourItemDelegate
import kotlinx.android.synthetic.main.item_tour.view.*


class TourViewHolder(itemView: View,delegate: TourItemDelegate) : BaseViewHolder<TourVO>(itemView){
    override fun onBindData(data: TourVO) {
        mData = data
        Glide
            .with(itemView.context)
            .load(data.photos[0])
            .into(itemView.ivTourImage)

        itemView.tvTourTitle.text = data.name
        itemView.tvRating.text = data.averageRating

    }

    init {
        itemView.setOnClickListener{
            mData?.let {
                delegate.onTapTourItem(it.name)
            }
        }
    }

}