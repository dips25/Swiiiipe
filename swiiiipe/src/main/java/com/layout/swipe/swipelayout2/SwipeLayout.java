package com.layout.swipe.swipelayout2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;


public class SwipeLayout extends RelativeLayout {

    private static final String TAG = SwipeLayout.class.getName();

    Context context;

    int width , height;

    boolean isRunning = false;

    int eX;
    int SCREEN_WIDTH;

    ViewGroup swipeRoot;
    TextView textView;

    boolean isTouch;

    RecyclerView recyclerView;

    boolean isScrolling;


    public SwipeLayout(Context context) {
        super(context);
        this.context = context;
        SCREEN_WIDTH = Utils.getScreenWidth(context);
        setSwipeLayout();

    }

    public SwipeLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        this.context = context;
        SCREEN_WIDTH = Utils.getScreenWidth(context);
        setSwipeLayout();

    }



    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        this.width = w;
        this.height = h;

    }

    public void setSwipeLayout() {

        textView = new TextView(context);

        new Handler().post(()->{

            int width = MeasureSpec.makeMeasureSpec(SCREEN_WIDTH , MeasureSpec.EXACTLY);
            int height = MeasureSpec.makeMeasureSpec(0 , MeasureSpec.UNSPECIFIED);

            this.measure(width , height);

            int measuredWidth = this.getMeasuredWidth();
            int measuredHeight = this.getMeasuredHeight();

            Log.d(TAG, "setSwipeLayout: " + measuredHeight);


            LayoutParams rlp = new LayoutParams(measuredWidth
                    , measuredHeight);

            textView.setText("Undo");
            textView.setBackgroundColor(Color.RED);
            textView.setTextColor(Color.BLACK);
            textView.setGravity(Gravity.CENTER);
            textView.setLayoutParams(rlp);
            textView.setVisibility(INVISIBLE);

            this.addView(textView);



        });


    }






}
