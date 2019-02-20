package com.phellipesilva.daggerworkshop.view

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.swipeDown
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.phellipesilva.daggerworkshop.R
import io.appflate.restmock.RESTMockServer
import io.appflate.restmock.RESTMockServerStarter
import io.appflate.restmock.android.AndroidAssetsFileParser
import io.appflate.restmock.android.AndroidLogger
import io.appflate.restmock.utils.RequestMatchers
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java, false, false)

    @Before
    fun setup() {
        RESTMockServerStarter.startSync(
            AndroidAssetsFileParser(InstrumentationRegistry.getInstrumentation().context),
            AndroidLogger()
        )
    }

    @After
    fun tearDown() = RESTMockServer.shutdown()

    @Test
    fun shouldFetchMockedResponseAndShowDataOnScreenWhenSwipingToRefresh() {
        RESTMockServer.whenGET(RequestMatchers.pathContains("users")).thenReturnFile(200, "users.json")

        activityRule.launchActivity(Intent())
        onView(withId(R.id.swipeRefreshLayout)).perform(swipeDown())

        onView(withText("phellipe")).check(matches(isDisplayed()))
    }
}