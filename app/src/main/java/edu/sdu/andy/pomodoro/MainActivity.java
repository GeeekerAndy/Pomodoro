package edu.sdu.andy.pomodoro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button tomatoButton = (Button)findViewById(R.id.bt_tomato);
        tomatoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TomatoActivity.class);
                startActivity(intent);
            }
        });
        tomatoButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if(v.getId() == R.id.bt_tomato) {
                            tomatoButton.setScaleX(0.9f);
                            tomatoButton.setScaleY(0.9f);
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        if(v.getId() == R.id.bt_tomato) {
                            tomatoButton.setScaleX(1);
                            tomatoButton.setScaleY(1);
                        }
                        break;

                }
                return false;
            }
        });

        final Button cafeButton = (Button)findViewById(R.id.bt_cafe);
        cafeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CoffeeActivity.class);
                startActivity(intent);
            }
        });
        cafeButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if(v.getId() == R.id.bt_cafe) {
                            cafeButton.setScaleX(0.9f);
                            cafeButton.setScaleY(0.9f);
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        if(v.getId() == R.id.bt_cafe) {
                            cafeButton.setScaleX(1);
                            cafeButton.setScaleY(1);
                        }
                        break;

                }
                return false;
            }
        });

    }
}
