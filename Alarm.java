package com.reuniware.alarmmanagertest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import android.content.Intent; import android.content.ComponentName;
import android.net.Uri;

public class Alarm extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            Toast.makeText(context, "hello", Toast.LENGTH_LONG).show();
            Log.d("alarm001", "boot");
            StartChrome(context);
        }
    }

    public void StartChrome(Context context) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setComponent(ComponentName.unflattenFromString("com.android.chrome/com.google.android.apps.chrome.Main"));
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setData(Uri.parse("https://ntic974.blogspot.com"));
        context.startActivity(intent);
    }

}
