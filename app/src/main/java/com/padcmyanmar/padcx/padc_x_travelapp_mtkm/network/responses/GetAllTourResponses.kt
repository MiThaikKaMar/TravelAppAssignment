package com.padcmyanmar.padcx.padc_x_travelapp_mtkm.network.responses

import com.google.gson.annotations.SerializedName
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.data.vos.TourVO
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.utils.CODE_RESPONSE_OK

data class GetAllTourResponses(
    @SerializedName("code")var code: Int=0,
    @SerializedName("message")var message: String="",
    @SerializedName("data")var data: ArrayList<TourVO>? = null
){
    fun isResponseOk():Boolean=(data !=null && code==CODE_RESPONSE_OK)
}