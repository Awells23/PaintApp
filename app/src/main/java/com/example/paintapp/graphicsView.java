package com.example.paintapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;

import androidx.annotation.ColorRes;

import java.util.LinkedList;

public class graphicsView extends View {
    doodleModel Model;
    Paint paint;

    public graphicsView(Context context, doodleModel doodle) {
        super(context);
        this.Model = doodle;
        paint = new Paint();
        paint.setStrokeWidth(40);

    }

    protected void onDraw(Canvas canvas) {
        //go thru list of points
        LinkedList<point> list = Model.getList();
        for (int i = 0; i < list.size(); i++) {
            //get color of point, convert color code to rgb, set paint color
            int color = list.get(i).color;
            color = convert(color);
            paint.setColor(color);

            //get x, y of point
            //draw point at x, y
            float x = list.get(i).x;
            float y = list.get(i).y;

            canvas.drawPoint(x,y,paint);
        }
        //get current color, convert color code to rgb, set paint color
        //draw filled square at bottom right corner
        int color = Model.getColor();
        color = convert(color);
        paint.setColor(color);

        int maxX = getWidth();
        int maxY = getHeight();

        canvas.drawRect(maxX,maxY,maxX-200,maxY-200, paint);

    }



    public int convert(int code) {
        if (code == 0) {
            //black
            return Color.rgb(0, 0, 0);
        }
        else if (code == 1) {
            //red
            return Color.rgb(255, 0, 0);
        }
        else if (code == 2) {
            //green
            return Color.rgb(0, 255, 0);
        }
        else if (code == 3) {
            //blue
            return Color.rgb(0, 0, 255);
        }
        else if (code == 4) {
            //yellow
            return Color.rgb(255, 255, 0);
        }
        else if (code == 5) {
            //brown
            return Color.rgb(165, 42, 42);
        }
        else if (code == 6) {
            //grey
            return Color.rgb(128, 128, 128);
        }
        else if (code == 7) {
            //white
            return Color.rgb(255, 255, 255);
        }
        else
            return Color.rgb(255,0,255);

    }
}