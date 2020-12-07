package com.reuniware.alarmmanagertest;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;
import android.content.Intent; import android.content.ComponentName;
import android.net.Uri;

import java.util.Calendar;

public class Alarm extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            Toast.makeText(context, "hello", Toast.LENGTH_LONG).show();
            Log.d("alarm001", "boot");

            try {
                AlarmManager alarmMgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
                Calendar time = Calendar.getInstance();
                time.setTimeInMillis(System.currentTimeMillis());
                time.add(Calendar.SECOND, 30);
                alarmMgr.set(AlarmManager.RTC_WAKEUP, time.getTimeInMillis(), pendingIntent);
            } catch (Exception e) {
                Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    }

}
