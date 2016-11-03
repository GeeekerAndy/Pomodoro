package edu.sdu.andy.pomodoro;

import android.app.NotificationManager;
import android.content.Context;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import cn.iwgang.countdownview.CountdownView;


public class TomatoActivity extends AppCompatActivity {

    private long tomatoTime = 25*60*1000;
//    private long tomatoTime = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tomato);

        Circle circle = (Circle) findViewById(R.id.circle_tomato);

        CircleAngleAnimation animation = new CircleAngleAnimation(circle, 360);
        animation.setDuration(tomatoTime);
        circle.startAnimation(animation);

        CountdownView mCvTomatoCountdown = (CountdownView)findViewById(R.id.cv_tomato_countdown);
        mCvTomatoCountdown.start(tomatoTime);
        mCvTomatoCountdown.setOnCountdownEndListener(new CountdownView.OnCountdownEndListener() {
            @Override
            public void onEnd(CountdownView cv) {
                //Define Notification Manager
                NotificationManager notificationManager = (NotificationManager) TomatoActivity.this.getSystemService(Context.NOTIFICATION_SERVICE);

//Define sound URI
                Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext())
                        .setSmallIcon(R.drawable.tomato)
                        .setContentTitle("Well done !")
                        .setContentText("Take a break.")
                        .setSound(soundUri); //This sets the sound to play

//Display notification
                notificationManager.notify(0, mBuilder.build());
            }
        });
    }
}

