package com.padcmyanmar.padcx.padc_x_travelapp_mtkm.data.vos

import com.google.gson.annotations.SerializedName

data class ReviewVO(
    @SerializedName("name")var name : String="",
    @SerializedName("score")var score : String="",
    @SerializedName("max_score")var maxScore: String="",
    @SerializedName("total_reviews")var totalReviews:String=""
)