package com.padcmyanmar.padcx.padc_x_travelapp_mtkm.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.R
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.data.vos.TourVO
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.mvp.presenters.TourDetailPresenter
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.mvp.presenters.TourDetailPresenterImpl
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.mvp.views.TourDetailView
import kotlinx.android.synthetic.main.item_tour_detail.*

class DetailActivity: BaseActivity(),TourDetailView {

    private lateinit var mDetailPresenter:TourDetailPresenter
    companion object{
        const val TOUR_NAME_EXTRA = "News Id Extra"
        fun newItent(context: Context, name : String): Intent {
            val intent =  Intent(context, DetailActivity::class.java)
            intent.putExtra(TOUR_NAME_EXTRA, name)
            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_tour_detail)

        setUpPresenter()
        val tourName=intent.getStringExtra(TOUR_NAME_EXTRA)
        mDetailPresenter.getTourbyName(tourName = tourName)
    }

    override fun displayNewsDetails(tour: LiveData<TourVO>) {
        tour.observe(this, Observer {
            bindData(it)
        })
    }

    private fun bindData(tour:TourVO){
        Glide
            .with(this)
            .load(tour.photos[0])
            .into(ivDetailImage)

        tvDetailName.text=tour.name
        tvDetailLocation.text=tour.location
        tvRatingNumber.text=tour.averageRating
        tvDescription.text=tour.description
    }

    override fun showErrorMessage(message: String) {
        showSnacker(message)
    }

    private fun setUpPresenter(){
        mDetailPresenter= ViewModelProviders.of(this).get(TourDetailPresenterImpl::class.java)
        mDetailPresenter.initPresenter(this)
    }
}