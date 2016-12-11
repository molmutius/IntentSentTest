package com.example.molmu.intentsenttest;

import android.support.test.espresso.intent.rule.IntentsTestRule;

public class TestRule<A extends ActivityUnderTest> extends IntentsTestRule<A>
{
    public TestRule(Class<A> activityClass) {
        super(activityClass);
    }
}
