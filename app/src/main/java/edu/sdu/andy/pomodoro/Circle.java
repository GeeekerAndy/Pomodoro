package edu.sdu.andy.pomodoro;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by andy on 11/1/16.
 */

public class Circle extends View {

    private static final int START_ANGLE_POINT = 270;

    private final Paint paint;
    private final RectF rect;
    private float angle;

    private WindowManager windowManager;
    private Point size;
    private int screenWidth;
    private int screenHeight;

    public Circle(Context context, AttributeSet attrs) {
        super(context, attrs);
        windowManager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        size = new Point();
        windowManager.getDefaultDisplay().getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;

        final int strokeWidth = 12;

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);
        paint.setColor(Color.BLACK);

        rect = new RectF(screenWidth/8, screenHeight/2 - screenWidth*3/8, screenWidth*7/8, screenHeight/2 + screenWidth*3/8);
        //Initial Angle (optional, it can be zero)
        this.angle = 0;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(rect, START_ANGLE_POINT, angle, false, paint);
    }

    public float getAngle() {
        return this.angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }
}
