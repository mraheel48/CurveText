package com.example.curvetext;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

public class MyCurveView extends View {

    private static final String QUOTE = "This is a curved text";
    private Path circle;
    private Paint cPaint;
    private Paint tPaint;

    public MyCurveView(Context context) {
        super(context);

        int color = Color.argb(127, 255, 0, 255);

        circle = new Path();
        circle.addCircle(230, 350, 150, Path.Direction.CW);

        cPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        cPaint.setStyle(Paint.Style.STROKE);
        cPaint.setColor(Color.LTGRAY);
        cPaint.setStrokeWidth(3);

        //setBackgroundResource(R.drawable.heart);

        tPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        tPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        tPaint.setColor(Color.BLACK);
        tPaint.setTextSize(50);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //canvas.drawTextOnPath(QUOTE, circle, 485, 20, tPaint);
        @SuppressLint("DrawAllocation") Path path = new Path();
        path.addCircle(250, 250, 200, Path.Direction.CW);
        canvas.drawTextOnPath(QUOTE, path, 485, 20, tPaint);
    }
}
