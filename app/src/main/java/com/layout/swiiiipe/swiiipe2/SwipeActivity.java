package com.layout.swiiiipe.swiiipe2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.layout.swipe.swipelayout2.CharModel;
import com.layout.swipe.swipelayout2.SwipeLayout;
import com.layout.swipe.swipelayout2.SwipeRecyclerView;
import com.layout.swipe.swipelayout2.SwipeViewHolder;

import java.util.ArrayList;

public class SwipeActivity extends AppCompatActivity {
    RelativeLayout swipeRoot;

    SwipeRecyclerView swipeRecycler;
    String[] countries = {"India" , "London" , "USA" , "Germany" , "Switzerland"};

    int[] resIds = {com.layout.swipe.swipelayout2.R.drawable.indiagate , com.layout.swipe.swipelayout2.R.drawable.indiagate , com.layout.swipe.swipelayout2.R.drawable.indiagate , com.layout.swipe.swipelayout2.R.drawable.indiagate , com.layout.swipe.swipelayout2.R.drawable.indiagate};

    ArrayList<CharModel> charModels = new ArrayList<>();



    public static boolean isScrolling = false;

    SampleRecyclerAdapter sampleRecyclerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRecycler = (SwipeRecyclerView) findViewById(R.id.swipeRecycler);
        swipeRecycler.setLayoutManager(new LinearLayoutManager(this));




        sampleRecyclerAdapter = new SampleRecyclerAdapter(countries , resIds);


        swipeRecycler.setAdapter(sampleRecyclerAdapter);

        sampleRecyclerAdapter.notifyDataSetChanged();




    }

    public class SampleRecyclerAdapter extends RecyclerView.Adapter<SampleRecyclerAdapter.ViewHolder> {

        ArrayList<CharModel> ch;
        String[] countries;
        int[] resIds;

        public SampleRecyclerAdapter(String[] countries,int[] resIds) {

            this.countries = countries;
            this.resIds = resIds;

        }



        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_recycler , parent , false));
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            String c = countries[position];
            int i = resIds[position];

            holder.nameText.setText(c);

            if (holder.isSwiped()) {


                holder.name.setVisibility(View.INVISIBLE);
                holder.removeLayout.setVisibility(View.VISIBLE);
                holder.removeLayout.text.setVisibility(View.VISIBLE);
                //holder.removeLayout.setBackgroundColor(Color.CYAN);

            } else {


                holder.removeLayout.setVisibility(View.VISIBLE);
                holder.removeLayout.text.setVisibility(View.INVISIBLE);
                holder.name.setVisibility(View.VISIBLE);


            }

            holder.itemView.setOnClickListener((v)->{

                Toast.makeText(SwipeActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                holder.isSwiped = false;
                notifyItemChanged(position);

            });





//            holder.itemView.setOnClickListener((v)->{
//
//                if (holder.isSwiped) {
//
//                    Toast.makeText(MainActivity.this, "Swiped", Toast.LENGTH_SHORT).show();
//
//                } else {
//
//                    Toast.makeText(MainActivity.this, "Not Swiped", Toast.LENGTH_SHORT).show();
//
//                }
//
//            });


            //holder.setIsRecyclable(false);

        }

        @Override
        public int getItemCount() {
            return countries.length;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public class ViewHolder extends SwipeViewHolder {


            public SwipeLayout removeLayout;
            CardView name;

            TextView nameText;


            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                //swipeRoot = (RelativeLayout) itemView.findViewById(R.id.swiperoot);
                removeLayout = (SwipeLayout) itemView.findViewById(R.id.removeLayout);
                name = (CardView) itemView.findViewById(R.id.name);
                nameText = (TextView) itemView.findViewById(R.id.nameText);
            }

            public CharModel notifyDataset(int position) {

                return charModels.get(position);
            }
        }


    }

}