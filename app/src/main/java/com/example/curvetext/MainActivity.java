package com.example.curvetext;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    MyCurveView myCurveView;
    ConstraintLayout layout;
    NewText myText;
    PaintView myPaintView;
    PaintView pV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myCurveView = new MyCurveView(this);
        myText = new NewText(this);
        myPaintView = new PaintView(this);

        layout = findViewById(R.id.layout);
        layout.addView(myPaintView);

    }

    public class PaintView extends View {
        private static final String Text = "Welcome To Code";
        private Path myArc;
        private Paint mPaintText;

        public PaintView(Context context) {
            super(context);
            //create Path object
            myArc = new Path();
            //create RectF Object
            RectF oval = new RectF(50,100,200,250);
            //add Arc in Path with start angle -180 and sweep angle 200
            myArc.addArc(oval, -180, 200);
            //create paint object
            mPaintText = new Paint(Paint.ANTI_ALIAS_FLAG);
            //set style
            mPaintText.setStyle(Paint.Style.FILL_AND_STROKE);
            //set color
            mPaintText.setColor(Color.WHITE);
            //set text Size
            mPaintText.setTextSize(20f);

        }

        @Override
        protected void onDraw(Canvas canvas) {
            //Draw Text on Canvas
            canvas.drawTextOnPath(Text, myArc, 0, 20, mPaintText);
            invalidate();
        }
    }
}