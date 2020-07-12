package com.padcmyanmar.padcx.padc_x_travelapp_mtkm.activities


import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.R
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.adapters.TourListAdapter
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.data.models.TourModel
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.data.models.TourModelImpl
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.data.vos.TourVO
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.mvp.presenters.TourPresenter
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.mvp.presenters.TourPresenterImpl
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.mvp.views.TourView
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.views.viewpods.EmptyViewPod
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(),TourView {

    private lateinit var mAdapter: TourListAdapter
    private lateinit var viewPodEmpty: EmptyViewPod
    private lateinit var mPresenter: TourPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpPresenter()
        hideEmptyView()
        setUpSwipeRefresh()
        setUpRecyclerView()
        setUpViewPod()

        mPresenter.onUiReady(this)

    }

    private fun setUpPresenter(){
        mPresenter=ViewModelProviders.of(this).get(TourPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun displayTourList(tourList: List<TourVO>) {
        mAdapter.setData(tourList.toMutableList())
    }

    override fun enableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing=true
    }

    override fun disableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing=false
    }

    override fun navigateToDetail(tourName: String) {
        startActivity(DetailActivity.newItent(this, tourName))
    }

    override fun showErrorMessage(message: String) {
        showSnacker(message)
    }

    override fun showEmptyView() {
        vpEmpty.visibility = View.VISIBLE
    }

    override fun hideEmptyView() {
        vpEmpty.visibility = View.GONE
    }

    private fun setUpViewPod() {
        viewPodEmpty = vpEmpty as EmptyViewPod
        viewPodEmpty.setEmptyData("There is nothing news now.",
            "https://image.freepik.com/free-photo/simple-empty-photo-frame_23-2148109093.jpg")
    }



    private fun setUpSwipeRefresh() {
        swipeRefreshLayout.setOnRefreshListener {
            mPresenter.onSwipeFresh(this)
        }
    }

    private fun setUpRecyclerView() {
        mAdapter = TourListAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(parent, LinearLayoutManager.VERTICAL, false)
        recyclerViewTour.layoutManager = linearLayoutManager
        recyclerViewTour.adapter = mAdapter
    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        compositeDisposable.dispose()
//    }
}
