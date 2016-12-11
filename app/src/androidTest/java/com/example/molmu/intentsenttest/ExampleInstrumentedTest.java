package com.example.molmu.intentsenttest;

import android.content.Intent;
import android.support.test.espresso.intent.Intents;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import junit.framework.Assert;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest
{
    /**
     * This rule takes care of all the boiler plate for us and automatically starts the
     * AUT before each test case.
     */
    @Rule
    public TestRule<ActivityUnderTest> testRule = new TestRule<>(ActivityUnderTest.class);

    @Test
    public void validateIntentSentToPackage()
    {
        // Trigger anything from the outside that causes our AUT to send an intent
        triggerIntentSending();

        // Using an intent matcher to validate that an intent resolving to the "other" activity has been sent
        //Matcher<Intent> expectedIntent = allOf(hasAction(Action.OUTBOUND_INTENT), hasData("some data"), toPackage(""));
        Matcher<Intent> expectedIntent = hasExtra(Intent.EXTRA_TEXT, "bla");
        Intents.intended(expectedIntent);
    }

    private void triggerIntentSending()
    {
        final String intentCommand = "am broadcast -a \"com.example.molmu.intentsenttest.EXTERNAL_INTENT_ACTION\" --es \"android.intent.extra.TEXT\" \"bla\"";
        try
        {
            final Process process = Runtime.getRuntime().exec(intentCommand);
            process.waitFor();
        }
        catch(IOException | InterruptedException e) {
            Log.e(getClass().getSimpleName(), "Failed to run shell command.");
            Assert.fail("Failed to run shell command.");
        }

        System.out.println("Done");
    }
}
