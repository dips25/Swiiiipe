package com.layout.swipe.swipelayout2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SwipeRecyclerView extends RecyclerView {

    Context context;

    ArrayList<BitmapRec> br = new ArrayList<>();

    MyItemTouchHelper itemTouchHelper;
    public SwipeRecyclerView(@NonNull Context context) {
        super(context);
        this.context = context;
        setListeners();
    }

    public SwipeRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        setListeners();
    }

    public SwipeRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        setListeners();
    }

    public void setListeners() {

         MyItemTouchHelper myItemTouchHelper = new MyItemTouchHelper();
        ItemTouchHelper itemTouchHelper1 = new ItemTouchHelper(myItemTouchHelper);

        itemTouchHelper1.attachToRecyclerView(this);





    }

    public class MyItemTouchHelper extends ItemTouchHelper.Callback {

        @Override
        public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

        }



        @Override
        public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull ViewHolder viewHolder) {
            return makeMovementFlags(0 , ItemTouchHelper.RIGHT);
        }

        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull ViewHolder viewHolder, @NonNull ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull ViewHolder viewHolder, int direction) {


            ((MainActivity.SampleRecyclerAdapter.ViewHolder) viewHolder).isSwiped = true;
            ((MainActivity.SampleRecyclerAdapter)SwipeRecyclerView.this.getAdapter()).notifyItemChanged(viewHolder.getAdapterPosition());






        }


    }


}
