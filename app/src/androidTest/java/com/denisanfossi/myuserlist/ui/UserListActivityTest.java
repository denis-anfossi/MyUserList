package com.denisanfossi.myuserlist.ui;


import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.denisanfossi.myuserlist.R;
import com.denisanfossi.myuserlist.ui.userlist.UserListActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class UserListActivityTest {

    @Rule
    public ActivityTestRule<UserListActivity> mActivityTestRule = new ActivityTestRule<>(UserListActivity.class);

    @Test
    public void userListActivityTest() {
        ViewInteraction recyclerView = onView(withId(R.id.activity_user_list_recycler_view));
        recyclerView.perform(actionOnItemAtPosition(2, click()));

        ViewInteraction textView = onView(allOf(withId(R.id.name_textview), isDisplayed()));
        textView.check(matches(withText("Lena")));

        pressBack();
    }

}
