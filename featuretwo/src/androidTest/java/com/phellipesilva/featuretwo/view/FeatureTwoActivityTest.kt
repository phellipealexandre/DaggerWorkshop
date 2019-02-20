package com.phellipesilva.featuretwo.view

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
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
class FeatureTwoActivityTest{

    @get:Rule
    var activityRule: ActivityTestRule<FeatureTwoActivity> = ActivityTestRule(FeatureTwoActivity::class.java, false, false)

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
    fun shouldFetchMockedResponseAndShowDataOnScreenForUserWithId1() {
        RESTMockServer.whenGET(RequestMatchers.pathContains("users")).thenReturnFile(200, "user1.json")

        val intent = Intent()
        intent.putExtra("id", 1)
        intent.putExtra("navigationId", 2)
        activityRule.launchActivity(intent)

        Espresso.onView(ViewMatchers.withText("This user named Phellipe Silva has an username phellipe and email Sincere@april.biz")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}