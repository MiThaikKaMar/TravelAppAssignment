package com.padcmyanmar.padcx.padc_x_travelapp_mtkm.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

open class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    fun showSnacker(message: String){
        Snackbar.make(window.decorView,message,Snackbar.LENGTH_LONG).show()
    }
}