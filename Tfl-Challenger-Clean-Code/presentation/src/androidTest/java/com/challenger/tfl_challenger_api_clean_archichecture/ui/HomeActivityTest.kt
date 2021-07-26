package com.challenger.tfl_challenger_api_clean_archichecture.ui

import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.challenger.tfl_challenger_api_clean_archichecture.R
import org.hamcrest.core.IsNot.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)

class HomeActivityTest{

    @get:Rule
    val activityRule = ActivityTestRule(HomeActivity::class.java)


    @Test
    fun test_home_activity_is_opened_not_errors() {
        onView(withId(R.id.homeActivity)).check( matches(ViewMatchers.isDisplayed()) )
    }

    @Test
    fun test_typing_search_container_info_shows_up() {
        val stringToBetyped = DataFactory.randomUuid()
        onView(withId(R.id.road_id_edittext)).perform(typeText(stringToBetyped))
        closeSoftKeyboard()
        onView(withId(R.id.conteiner_info_cardview)).check( matches(  isDisplayed()) )
    }
    @Test
    fun test_initially_container_info_is_not_visible_at_all() {
        onView(withId(R.id.conteiner_info_cardview)).check( matches( not( isDisplayed())) )
    }




}