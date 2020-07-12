package com.padcmyanmar.padcx.padc_x_travelapp_mtkm.data.vos


import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.persistence.typeconverters.PhotoListTypeConverter
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.persistence.typeconverters.ScoreAndReviewTypeConverter

@Entity(tableName = "tour")
@TypeConverters(ScoreAndReviewTypeConverter::class, PhotoListTypeConverter::class)
data class TourVO (
    @PrimaryKey
    @SerializedName("name")var name:String="",
    @SerializedName("description")var description:String="",
    @SerializedName("location")var location:String="",
    @SerializedName("average_rating")var averageRating:String="",
    @SerializedName("scores_and_reviews")var scoresAndReviews : ArrayList<ReviewVO> = arrayListOf(),
    @SerializedName("photos")var photos : ArrayList<String> = arrayListOf()
)