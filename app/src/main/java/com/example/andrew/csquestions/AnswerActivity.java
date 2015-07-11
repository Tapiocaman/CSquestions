package com.example.andrew.csquestions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;

import static android.support.v4.app.ActivityCompat.startActivity;

public class AnswerActivity extends Activity {
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
                if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffY < 0) {
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

    private void onSwipeTop(){
        Intent intent = new Intent(this, QuestionActivity.class);
        startActivity(intent);
    }

}
