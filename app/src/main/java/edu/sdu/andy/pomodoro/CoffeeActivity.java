package edu.sdu.andy.pomodoro;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.iwgang.countdownview.CountdownView;

public class CoffeeActivity extends AppCompatActivity {

    private long coffeeTime = 5*60*1000;
//    private long coffeeTime = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);

        Circle circle = (Circle) findViewById(R.id.circle_coffee);

        CircleAngleAnimation animation = new CircleAngleAnimation(circle, 360);
        animation.setDuration(coffeeTime);
        circle.startAnimation(animation);

        CountdownView mCvCoffeeCountdown = (CountdownView)findViewById(R.id.cv_coffee_countdown);
        mCvCoffeeCountdown.start(coffeeTime);
        mCvCoffeeCountdown.setOnCountdownEndListener(new CountdownView.OnCountdownEndListener() {
            @Override
            public void onEnd(CountdownView cv) {
                //Define Notification Manager
                NotificationManager notificationManager = (NotificationManager) CoffeeActivity.this.getSystemService(Context.NOTIFICATION_SERVICE);

                //Define sound URI
                Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext());
                mBuilder.setContentTitle("Time Up.");
                mBuilder.setContentText("Work with passion!");
                mBuilder.setSmallIcon(R.drawable.cafe);
                mBuilder.setLargeIcon(BitmapFactory.decodeResource(CoffeeActivity.this.getResources(), R.drawable.tomato));
                mBuilder.setSound(soundUri); //This sets the sound to play

                //Set the notification's click behaviour
                Intent resultIntent = new Intent(CoffeeActivity.this, MainActivity.class);
                PendingIntent resultPendingIntent = PendingIntent.getActivity(CoffeeActivity.this, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                mBuilder.setContentIntent(resultPendingIntent);
                mBuilder.setAutoCancel(true);

                //Display notification
                notificationManager.notify(0, mBuilder.build());
            }
        });
    }
}
