package com.jugal.rest_a_sure;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    private Context mContext;
    private List<Dishes> mData;

    public RecyclerViewAdapter(Context mContext, List<Dishes> mData) {
        this.mContext =  mContext;
        this.mData =  mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_cuisine_book,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_cuisine.setText(mData.get(position).getName());
        holder.img_cuisine_thumbnail.setImageResource(mData.get(position).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext,MapActivity.class);
                //Type statements to pass data to the Map Activity

                //Start the Activity
                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_cuisine;
        ImageView img_cuisine_thumbnail;
        CardView cardView ;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_cuisine = (TextView) itemView.findViewById(R.id.cuisine_name);
            img_cuisine_thumbnail = (ImageView) itemView.findViewById(R.id.cuisine_img);
            cardView = (CardView) itemView.findViewById(R.id.cardview_cuisines);
        }
    }





}
