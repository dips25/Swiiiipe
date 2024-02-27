package com.layout.swipe.swipelayout2;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class SwipeRecyclerView extends RecyclerView {

    Context context;

    private static int SCREEN_WIDTH = 0;

    //ArrayList<BitmapRec> br = new ArrayList<>();

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

        SCREEN_WIDTH = Utils.getScreenWidth(this.context) - 30;


        MyItemTouchHelper myItemTouchHelper = new MyItemTouchHelper();
        ItemTouchHelper itemTouchHelper1 = new ItemTouchHelper(myItemTouchHelper);

        itemTouchHelper1.attachToRecyclerView(this);

    }

    @Nullable
    @Override
    public Adapter getAdapter() {
        return super.getAdapter();
    }

    public class MyItemTouchHelper extends ItemTouchHelper.Callback {

        Canvas c;
        RecyclerView rv;

        @Override
        public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {

            this.rv = recyclerView;
            this.c = c;



            if (((SwipeViewHolder) viewHolder).isSwiped() && actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {

                return;
            }

                if (dX >= SCREEN_WIDTH) {

                    //(SwipeRecyclerView.this.getAdapter()).notifyItemRemoved(viewHolder.getAdapterPosition());

                    super.onChildDraw(c , recyclerView , viewHolder , 0 , 0 , ItemTouchHelper.ACTION_STATE_SWIPE , false);

//                    ((ParkAdapter.ViewHolder) viewHolder).linearroot.setVisibility(GONE);
//                    ((ParkAdapter.ViewHolder) viewHolder).viewHolderRoot.textView.setVisibility(VISIBLE);
                    ((SwipeViewHolder)viewHolder).setSwiped(true);


                    (SwipeRecyclerView.this.getAdapter()).notifyItemChanged(((SwipeViewHolder)viewHolder).getAdapterPosition());




                    return;




            } else {

                super.onChildDraw(c, rv, viewHolder, dX, 0, ItemTouchHelper.ACTION_STATE_SWIPE, true);

            }




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
//
//            Log.d(SwipeRecyclerView.this.getClass().getName(), "onSwiped: " + viewHolder.getClass().getName());
//
//            if (((SwipeViewHolder) viewHolder).isSwiped()) {
//
//
//                return;
//            }
//
//
//
//            this.onChildDraw(c, rv, viewHolder, 0, 0, 0, false);
//
////            new Handler().postDelayed(new Runnable() {
////                @Override
////                public void run() {
////
////                    retainChild(viewHolder);
////
////                }
////            } , 500);














        }


    }


}
