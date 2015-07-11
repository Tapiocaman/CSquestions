package com.example.andrew.csquestions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class QuestionActivity extends Activity {

    private static final int SWIPE_THRESHOLD = 100;
    private static final int SWIPE_VELOCITY_THRESHOLD = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
    }

    private GestureDetector.OnGestureListener mOnGesture = new GestureDetector.SimpleOnGestureListener() {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            boolean result = false;
            try {
                float diffY = e2.getY() - e1.getY();
                float diffX = e2.getX() - e1.getX();
                if (Math.abs(diffX) > Math.abs(diffY)) {
                    if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) {
                            onSwipeRight();
                        } else {
                            onSwipeLeft();
                        }
                    }
                    result = true;
                } else if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffY > 0) {
                        onSwipeBottom();
                    }
                    else if (diffY > 0) {
                        onSwipeTop();
                    }
                }
                result = true;

            } catch (Exception exception) {
                exception.printStackTrace();
            }

            return result;
        }
    };

    private void onSwipeRight(){
        Intent intent = new Intent(this, QuestionActivity.class);
        startActivity(intent);
    }
    private void onSwipeLeft(){
        Intent intent = new Intent(this, QuestionActivity.class);
        startActivity(intent);
    }
    private void onSwipeBottom(){
        Intent intent = new Intent(this, QuestionActivity.class);
        startActivity(intent);
    }
    private void onSwipeTop(){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}
