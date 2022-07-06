package com.example.notification_demo.app;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent ;
import android.content.Intent ;
import android.os.Build;

import com.example.notification_demo.utils.utils;

public class Notifs extends Application {

    private Object NotificationChannel;

    @Override
    public void onCreate() {
        super.onCreate();

        createFirstNotifChannel();
    }

    private void createFirstNotifChannel()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(utils.FIRST_CHANNEL_ID, utils.FIRST_CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);

            channel.setDescription(utils.FIRST_CHANNEL_DESCRIPTION);

            NotificationManager manager = getSystemService(NotificationManager.class);

            manager.createNotificationChannel(channel);
        }
    }

}

