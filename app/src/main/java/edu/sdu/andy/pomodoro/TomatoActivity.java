package edu.sdu.andy.pomodoro;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
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

        CountdownView mCvTomatoCountdown = (CountdownView) findViewById(R.id.cv_tomato_countdown);
        mCvTomatoCountdown.start(tomatoTime);

        mCvTomatoCountdown.setOnCountdownEndListener(new CountdownView.OnCountdownEndListener() {
            @Override
            public void onEnd(CountdownView cv) {
                //Define Notification Manager
                NotificationManager notificationManager = (NotificationManager) TomatoActivity.this.getSystemService(Context.NOTIFICATION_SERVICE);

                //Define sound URI
                Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext());
                mBuilder.setContentTitle("Well done !");
                mBuilder.setContentText("Take a break.");
//                    mBuilder.setColor(TomatoActivity.this.getResources().getColor(R.color.mainColor));
                mBuilder.setSmallIcon(R.drawable.tomato_black_hollow);
                mBuilder.setLargeIcon(BitmapFactory.decodeResource(TomatoActivity.this.getResources(), R.drawable.tomato));
                mBuilder.setSound(soundUri); //This sets the sound to play

                //Set the notification's click behavior
                Intent resultIntent = new Intent(TomatoActivity.this, MainActivity.class);
                PendingIntent resultPendingIntent = PendingIntent.getActivity(TomatoActivity.this, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                mBuilder.setContentIntent(resultPendingIntent);
                mBuilder.setAutoCancel(true);
                //Display notification
                notificationManager.notify(0, mBuilder.build());
            }
        });

        //Change default font.
//        mCvTomatoCountdown.setTypeface();
    }
}

