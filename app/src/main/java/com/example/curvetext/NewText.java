package com.example.curvetext;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

public class NewText extends View {

    private static final String YOUR_TEXT = "something cool";
    private Path _arc;
    private Paint _paintText;
    RectF oval;
    private Paint tPaint;

    public NewText(Context context) {
        super(context);

        _arc = new Path();
        oval  = new RectF(50,100,200,250);;

        _arc.addArc(oval, -180, 200);
        _paintText = new Paint(Paint.ANTI_ALIAS_FLAG);
        _paintText.setStyle(Paint.Style.FILL_AND_STROKE);
        _paintText.setColor(Color.WHITE);
        _paintText.setTextSize(20f);

        tPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        tPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        tPaint.setColor(Color.BLACK);
        tPaint.setTextSize(50f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        /*canvas.drawTextOnPath(YOUR_TEXT, _arc, 0, 20, _paintText);
        invalidate();*/

        @SuppressLint("DrawAllocation") Path path = new Path();
        path.addArc(oval, -180, 200);

        canvas.drawTextOnPath(YOUR_TEXT, path, 200, 200, tPaint);
        //path.addArc(oval, 0, 180);
    }
}
