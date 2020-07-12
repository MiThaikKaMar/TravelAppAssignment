package com.padcmyanmar.padcx.padc_x_travelapp_mtkm.data.models

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.data.vos.TourVO
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.utils.EM_NO_INTERNET_CONNECTION
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object TourModelImpl : TourModel, BaseModel(){

    override fun getAllTour(onError: (String) -> Unit): LiveData<List<TourVO>> {
        return mTheDB.tourDao()
            .getAllTour()
    }

    @SuppressLint("CheckResult")
    override fun getAllNewsFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit) {
        mTourApi
            .getAllTours()
            .map { it.data?.toList() ?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                mTheDB.tourDao().insertAllTour(it)
            },{
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    override fun getTourByName(dataName: String): LiveData<TourVO> {
        return mTheDB.tourDao().getTourByName(dataName)
    }
}