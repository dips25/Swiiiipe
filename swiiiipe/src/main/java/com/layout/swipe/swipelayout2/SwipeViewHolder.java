package com.layout.swipe.swipelayout2;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SwipeViewHolder extends RecyclerView.ViewHolder {

    public boolean isSwiped;
    public SwipeViewHolder(@NonNull View itemView) {
        super(itemView);

        this.isSwiped = false;
    }

    public boolean isSwiped() {
        return isSwiped;
    }

    public void setSwiped(boolean swiped) {
        isSwiped = swiped;
    }
}
