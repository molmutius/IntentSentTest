package com.example.molmu.intentsenttest;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityUnderTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_under_test);
        registerReceiver(new ExternalIntentReceiver(), new IntentFilter(Action.INBOUND_INTENT));
    }
}
