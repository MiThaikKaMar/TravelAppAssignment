package com.padcmyanmar.padcx.padc_x_travelapp_mtkm.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PhotoListTypeConverter {
    @TypeConverter
    fun toString(photoList: ArrayList<String>) : String {
        return Gson().toJson(photoList)
    }

    @TypeConverter
    fun tophotoList(photoListJsonString: String) : ArrayList<String>{
        val photoListType = object : TypeToken<ArrayList<String>>() {}.type
        return Gson().fromJson(photoListJsonString, photoListType)
    }
}