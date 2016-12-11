package com.example.molmu.intentsenttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Molmu on 10.12.2016.
 */

public class ExternalIntentReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(getClass().getSimpleName(), "Received Extra: " + intent.getExtras().getString(Intent.EXTRA_TEXT));
        sendIntent(context);
    }

    private void sendIntent(Context context) {
        final Intent intent = new Intent(Action.OUTBOUND_INTENT);
        context.sendBroadcast(intent);
    }
}
