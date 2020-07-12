package com.padcmyanmar.padcx.padc_x_travelapp_mtkm

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.data.models.TourModel
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.data.models.TourModelImpl
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.data.vos.TourVO
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.mvp.presenters.TourPresenterImpl
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.mvp.views.TourView
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class TourPresenterImplTest {

    private lateinit var mPresenter : TourPresenterImpl

    @RelaxedMockK
    private lateinit var mView : TourView

    private lateinit var mModel : TourModel

    @Before
    fun setUpPresenter(){
        MockKAnnotations.init(this)

        TourModelImpl.initDatabase(ApplicationProvider.getApplicationContext())
        mModel=TourModelImpl

        mPresenter= TourPresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.mTourModel=this.mModel

    }

    @Test
    fun onTapTourItem_callNavigaterToDetail(){
        val tour = TourVO()
        tour.name="Malaysia"

        mPresenter.onTapTourItem(tour.name)
        verify {
            mView.navigateToDetail(tour.name)
        }
    }

    @Test
    fun getTourData_callEnableSwipeFresh(){
        val lifecycleOwner = mock(LifecycleOwner::class.java)
        val lifecycleRegistry = LifecycleRegistry(lifecycleOwner)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        `when`(lifecycleOwner.lifecycle).thenReturn(lifecycleRegistry)

        mPresenter.getTourData(lifecycleOwner)
        verify {
            mView.enableSwipeRefresh()
        }
    }
}