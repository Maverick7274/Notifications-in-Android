package com.example.notification_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.notification_demo.utils.utils;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Make_Notification = findViewById(R.id.Make_Notification);

        Make_Notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNotification();
            }
        });
    }

    private void createNotification() {

        Intent intent1 = new Intent(MainActivity.this
                ,MainActivity2.class);

        intent1.putExtra("Accept", true);
        intent1.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP
                |Intent.FLAG_ACTIVITY_NEW_TASK);

        PendingIntent pendingIntent1 = PendingIntent.getActivity(
                MainActivity.this, 0, intent1,PendingIntent.FLAG_ONE_SHOT
        );

        Intent intent2 = new Intent(MainActivity.this
                ,MainActivity2.class);

        intent2.putExtra("Deny", false);
        intent2.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP
                |Intent.FLAG_ACTIVITY_NEW_TASK);

        PendingIntent pendingIntent2 = PendingIntent.getActivity(
                MainActivity.this, 1, intent2,PendingIntent.FLAG_ONE_SHOT
        );

        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);




        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, utils.FIRST_CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_logo)
                .setContentTitle(utils.FIRST_NOTIF_TITLE)
                .setContentText(utils.FIRST_NOTIF_DESC)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .addAction(R.drawable.ic_launcher_foreground, "Accept", pendingIntent1).setColor(Color.GREEN)
                .addAction(R.drawable.ic_launcher_foreground, "Deny", pendingIntent2).setColor(Color.RED)
                .setAutoCancel(true);


            NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
            managerCompat.notify(utils.FIRST_NOTIF_ID, builder.build());
    }
}