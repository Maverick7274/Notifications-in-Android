package com.example.notification_demo;

import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = findViewById(R.id.text_view);

        NotificationManager manager = (NotificationManager) getApplicationContext()
                .getSystemService(NOTIFICATION_SERVICE);
        manager.cancelAll();

        if(getIntent().hasExtra("Accept")){
            textView.setText("You have Approved");
            textView.setTextColor(Color.GREEN);
        }else if(getIntent().hasExtra("Deny")){
            textView.setText("You have Denied!");
            textView.setTextColor(Color.RED);
        }
    }
}