package com.padcmyanmar.padcx.padc_x_travelapp_mtkm.adapters

import androidx.recyclerview.widget.RecyclerView
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.views.viewholders.BaseViewHolder

abstract class BaseAdapter<T: BaseViewHolder<W>,W>: RecyclerView.Adapter<T>() {
    var mData:MutableList<W> = arrayListOf()

    override fun getItemCount(): Int {
        return mData.count()
    }

    override fun onBindViewHolder(holder: T, position: Int) {
        holder.onBindData(mData[position])
    }

    fun setData(data: MutableList<W>){
        mData=data
        notifyDataSetChanged()
    }

    fun appendingData(data:List<W>){
        mData.addAll(data)
        notifyDataSetChanged()
    }
}