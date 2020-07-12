package com.padcmyanmar.padcx.padc_x_travelapp_mtkm.data.models

import android.content.Context
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.network.TourApi
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.persistence.db.TourDB
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.utils.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel  {

    protected  var mTourApi: TourApi
    protected lateinit var mTheDB : TourDB

    init {
        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(mOkHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        mTourApi = retrofit.create(TourApi::class.java)
    }
    fun initDatabase(context: Context) {
        mTheDB = TourDB.getDBInstance(context)
    }

}