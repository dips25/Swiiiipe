package com.layout.swipe.swipelayout2;

import android.graphics.Rect;

public class BitmapRec {

    int left;
    int top;
    int right;
    int bottom;

   Rect rect;

    public BitmapRec(int left, int top, int right, int bottom , Rect rect) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.rect = rect;

    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

    public Rect getRect() {
        return rect;
    }

    public void setRect(Rect rect) {
        this.rect = rect;
    }

    @Override
    public int hashCode() {
        return top;
    }
}
