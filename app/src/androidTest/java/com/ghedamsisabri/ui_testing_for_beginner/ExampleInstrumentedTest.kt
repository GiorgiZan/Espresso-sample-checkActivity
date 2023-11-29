package com.ghedamsisabri.ui_testing_for_beginner

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.ghedamsisabri.ui_testing_for_beginner.Helper.assertIsViewDisplayed
import com.ghedamsisabri.ui_testing_for_beginner.Helper.getText
import com.ghedamsisabri.ui_testing_for_beginner.Helper.isTextOnScreen
import com.ghedamsisabri.ui_testing_for_beginner.Helper.isViewDisplayed
import com.ghedamsisabri.ui_testing_for_beginner.Helper.tap
import org.hamcrest.Matcher
import org.junit.Assert

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule


@RunWith(AndroidJUnit4::class)
@LargeTest
class ExampleInstrumentedTest {

    @get:Rule var activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun checkMainAndSecondPage() {
        mainPage.assertIsViewDisplayed()
        NextBtn.tap()
        secondPageTitle.assertIsViewDisplayed()
        Assert.assertTrue(isTextOnScreen("SecondaryActivity"))
        BackBtn.assertIsViewDisplayed()
    }

    @Test
    fun checkSecondPage1() {
        mainPage.assertIsViewDisplayed()
        NextBtn.tap()
        BackBtn.tap()
        Assert.assertTrue(isTextOnScreen("MainActivity"))
        NextBtn.assertIsViewDisplayed()

    }

    companion object{
        val mainPage: Matcher<View> by lazy { withId(R.id.main) }
        val mainPageTitle: Matcher<View> by lazy { withId(R.id.activity_main_title) }
        val NextBtn: Matcher<View> by lazy { withId(R.id.button_next_activity) }
        val BackBtn: Matcher<View> by lazy { withId(R.id.button_back) }
        val secondPageTitle: Matcher<View> by lazy { withId(R.id.activity_secondary_title) }
    }
}