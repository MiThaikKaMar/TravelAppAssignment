package com.padcmyanmar.padcx.padc_x_travelapp_mtkm.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.data.vos.ReviewVO

class ScoreAndReviewTypeConverter {
    @TypeConverter
    fun toString(scoreList: ArrayList<ReviewVO>) : String {
        return Gson().toJson(scoreList)
    }

    @TypeConverter
    fun toScoreList(scoreListJsonString: String) : ArrayList<ReviewVO>{
        val scoreListType = object : TypeToken<ArrayList<ReviewVO>>() {}.type
        return Gson().fromJson(scoreListJsonString, scoreListType)
    }
}