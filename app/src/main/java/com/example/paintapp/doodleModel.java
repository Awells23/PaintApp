package com.example.paintapp;

import java.util.LinkedList;

public class doodleModel {
    //initialize variables
    public int color;
    public LinkedList<point> list;

    public doodleModel(){
        color = 0;
        list = new LinkedList<>();
    }
    public void nextColor(){
        color = (color+1)%8;
    }
    public void addPoint(float x,float y){
        point point = new point(x,y,color);
        list.add(point);
    }

    public int getColor(){
        return color;
    }

    public LinkedList<point> getList(){
        return list;
    }

}
