package com.carlos.touchevent.touchevent;

import android.app.Activity;
import android.gesture.Gesture;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.GestureDetectorCompat;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.TextureView;
import android.widget.TextView;

public class MainActivity extends Activity implements
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {

    private GestureDetectorCompat mDetector;
    private static final String gestureTag ="DEBUG";
    private ConstraintLayout view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDetector = new GestureDetectorCompat(this,this);
        mDetector.setOnDoubleTapListener(this);
        this.view = (ConstraintLayout) findViewById(R.id.home_view);
    }

    public boolean onTouchEvent (MotionEvent event){
        this.mDetector.onTouchEvent (event);
        TextView textView = findViewById(R.id.hello_world);
        textView.setText("Touch coordinates : " + String.valueOf(event.getX()) + "x" + String.valueOf(event.getY()));
        return super.onTouchEvent(event);

    }
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        this.view.setBackgroundColor(Color.BLUE);
        TextView textView = findViewById(R.id.hello_world);
        textView.setTextColor(Color.RED);
        textView.setTextSize(50);
        Log.d(gestureTag, "Single Tap");
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        this.view.setBackgroundColor(Color.RED);
        TextView textView = findViewById(R.id.hello_world);
        textView.setTextColor(Color.BLUE);
        textView.setTextSize(25);
        Log.d(gestureTag, "DoubleTap");
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        this.view.setBackgroundColor(Color.GREEN);
        TextView textView = findViewById(R.id.hello_world);
        textView.setTextColor(Color.BLACK);
        textView.setTextSize(70);
        Log.d(gestureTag, "DoubleTap Event");
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        this.view.setBackgroundColor(Color.YELLOW);
        TextView textView = findViewById(R.id.hello_world);
        textView.setTextColor(Color.BLUE);
        textView.setTextSize(100);
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        this.view.setBackgroundColor(Color.WHITE);
        TextView textView = findViewById(R.id.hello_world);
        textView.setTextColor(Color.BLACK);
        textView.setTextSize(30);
        Log.d(gestureTag, "Single Tap UP");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        this.view.setBackgroundColor(Color.BLACK);
        TextView textView = findViewById(R.id.hello_world);
        textView.setTextColor(Color.WHITE);
        textView.setTextSize(10);
        Log.d(gestureTag, "OnScroll");
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        this.view.setBackgroundColor(Color.GRAY);
        TextView textView = findViewById(R.id.hello_world);
        textView.setTextColor(Color.GREEN);
        textView.setTextSize(60);
        Log.d(gestureTag, "LongPress");

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        this.view.setBackgroundColor(Color.MAGENTA);
        TextView textView = findViewById(R.id.hello_world);
        textView.setTextColor(Color.BLACK);
        textView.setTextSize(15);
        Log.d(gestureTag, "Fling");
        return false;
    }

}
