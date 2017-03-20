package com.example.meruguabhishek.zoompinch;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ListView;

/**
 * Created by meruguabhishek on 2017-03-19.
 */

public class ScalableListView  extends GridView  {
    private static final int INVALID_POINTER_ID = -1;
    private int mActivePointerId = INVALID_POINTER_ID;
    private ScaleGestureDetector mScaleDetector;

    private float mScaleFactor = 1.f;
    private float width;
    private TouchHandler touchHandler;
    private float height;

    public TouchHandler getTouchHandler() {
        return touchHandler;
    }

    public void setTouchHandler(TouchHandler touchHandler) {
        this.touchHandler = touchHandler;
    }


    public interface  TouchHandler{
//        public void onTouch(MotionEvent ev);
        public void onScaleChanged(float scale);
    }
    public ScalableListView(Context context) {
        super(context);
        mScaleDetector = new ScaleGestureDetector(getContext(), new ScaleListener());
    }

    public ScalableListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mScaleDetector = new ScaleGestureDetector(getContext(), new ScaleListener());
    }

    public ScalableListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mScaleDetector = new ScaleGestureDetector(getContext(), new ScaleListener());
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public boolean onTouchEvent(@NonNull MotionEvent ev) {
        super.onTouchEvent(ev);
//        final int action = ev.getAction();
        mScaleDetector.onTouchEvent(ev);
        return true;
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            mScaleFactor *= detector.getScaleFactor();
            mScaleFactor = Math.max(0.8f, Math.min(mScaleFactor, 1.2f));
            touchHandler.onScaleChanged(mScaleFactor);
            invalidate();
            return true;
        }
    }
}
