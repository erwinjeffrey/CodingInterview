package com.coding.interviw.recursionAndDanamicProg;

public class Point {
    public int y;
    public int x;

    public Point(int y, int x){
        this.y = y;
        this.x = x;
    }

    @Override
    public String toString() {
        return "Point{" +
                "y=" + y +
                ", x=" + x +
                '}';
    }
}
