package com.example.yxys;

public class DotBean {

    private int x1; //起点x
    private int y1; //起点y
    private int x2; //终点x
    private int y2; //终点y
    private boolean isXRound; // 圆弧
    private boolean isYRound; // 圆弧

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public boolean isXRound() {
        return isXRound;
    }

    public void setXRound(boolean XRound) {
        isXRound = XRound;
    }

    public boolean isYRound() {
        return isYRound;
    }

    public void setYRound(boolean YRound) {
        isYRound = YRound;
    }

    private DotBean() {
    }

    public DotBean(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

    }

}
