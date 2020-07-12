package com.padcmyanmar.padcx.padc_x_travelapp_mtkm.UiTest

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.R
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.activities.MainActivity
import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.views.viewholders.TourViewHolder
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class GoToDetailTest {

private val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    fun setUp(){
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun tapTourItem_navigateToDetail(){

        onView(withId(R.id.recyclerViewTour))
            .perform(RecyclerViewActions.actionOnItemAtPosition<TourViewHolder>(1,click()))
        onView(withId(R.id.tvDescription)).check(matches(isDisplayed()))
    }
}