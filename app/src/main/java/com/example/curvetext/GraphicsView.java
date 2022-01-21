package com.example.curvetext;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

public class GraphicsView extends View {

    private static final String MY_TEXT = "Draw Text on Curve aba sdkahf dfs dfs sfd sdf";
    private final Path mArc;

    private final Paint mPaintText;

    public GraphicsView(Context context) {
        super(context);

        mArc = new Path();
        RectF oval = new RectF(50,100,300,350);
        mArc.addArc(oval, -180, 360);
        mPaintText = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintText.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaintText.setColor(Color.BLACK);
        mPaintText.setTextSize(25f);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawTextOnPath(MY_TEXT, mArc, 0, 0, mPaintText);
        invalidate();
    }
}