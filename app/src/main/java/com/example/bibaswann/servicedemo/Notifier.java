package com.example.bibaswann.servicedemo;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;

import java.util.Calendar;

/**
 * Created by bibaswann on 21/2/18.
 */

public class Notifier {
    Context mContext;
    NotificationManager mNotifyManager;
    NotificationCompat.Builder mBuilder;
    int id;

    Notifier(Context context) {
        mContext = context;
        id = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
    }

    // TODO: 25/2/18 fix oreo notification problem

    public void showStickyNotification() {
        mNotifyManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        mBuilder = new NotificationCompat.Builder(mContext);
        mBuilder.setContentTitle("Work in progress")
                .setSmallIcon(R.mipmap.ic_launcher_round);
    }

    public void updateNotification(int percent) {
        if (percent == 100) {
            mBuilder.setContentText("Job complete").setProgress(0, 0, false);
            mNotifyManager.notify(id, mBuilder.build());
        }
        mBuilder.setProgress(100, percent, false);
        mNotifyManager.notify(id, mBuilder.build());
    }
}
