package com.example.bibaswann.servicedemo;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

/**
 * Created by bibaswann on 21/2/18.
 */

public class SampleService extends IntentService {
    Notifier notifier;

    public SampleService() {
        //getApplicationContext() or this does not work here.
        //If anybody can find out why, please share your answer
        super("SampleService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        notifier = new Notifier(this);
        notifier.showStickyNotification();
        doLengthyWork();
    }

    private void doLengthyWork() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    try {
                        Thread.sleep(100);
                        updatePercentage(i);
                    } catch (InterruptedException ignored) {
                    }
                }
            }
        }).start();
    }

    private void updatePercentage(int percent) {
        notifier.updateNotification(percent);
    }
}
