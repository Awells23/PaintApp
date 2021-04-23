package com.example.paintapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class MainActivity extends Activity {
    public doodleModel Model;
    public graphicsView view;
    public  GestureDetector gestureDetector;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Model = new doodleModel();
        view = new graphicsView(this,Model);


        setContentView(view);

        TouchHandler temp = new TouchHandler();
        gestureDetector = new GestureDetector(this, temp);

    }

    public boolean onTouchEvent(MotionEvent event) {
        //find x and y of event
        float x =  event.getX();
        float y =  event.getY();
        boolean inside = check(x,y);

        if(inside){
            //pass to gesture detector
            gestureDetector.onTouchEvent(event);
        }
        else {
            int action1 = event.getAction();
            //if action is down or move

            if (action1 == MotionEvent.ACTION_DOWN){

                //find x, y of event
                 x = event.getRawX();
                 y = event.getRawY();
                 //adjust y
                Model.addPoint(x,y);
                view.postInvalidate();
                return true;
            }
             else if(action1 == MotionEvent.ACTION_MOVE){
                 x =  event.getRawX();
                 y =  event.getRawY();
                 //adjust y
                 Model.addPoint(x,y);
                 view.postInvalidate();
                 return true;
            }
        }
        return true;
    }

    public boolean check(float x, float y){
        //adjust y
        //check x and y inside square
        int maxX = view.getWidth();
        int maxY = view.getHeight();
        if (x >= maxX - 200 && x<= maxX && y >= maxY - 200 && y<= maxY){
            return true;
        }
        else
            return false;

    }


    private class TouchHandler extends GestureDetector.SimpleOnGestureListener
    {
        public boolean onSingleTapConfirmed(MotionEvent event){
            Model.nextColor();
            view.postInvalidate();
            return true;
        }
    }
}