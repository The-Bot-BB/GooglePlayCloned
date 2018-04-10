package com.pushpal.googleplayclone.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pushpal.googleplayclone.R;
import com.pushpal.googleplayclone.models.PopularItemAppModel;

import java.util.ArrayList;

public class PopularItemAppAdapter extends RecyclerView.Adapter<PopularItemAppAdapter.MyViewHolder> {

    private ArrayList<PopularItemAppModel> mArrayList;

    PopularItemAppAdapter(ArrayList<PopularItemAppModel> mArrayList) {
        this.mArrayList = mArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_app_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //holder.iv_card_graphics.setImageDrawable(mArrayList.get(position).getItemImage());
        holder.tv_card_header.setText(mArrayList.get(position).getItemHeader());
        holder.tv_card_sub_header.setText(mArrayList.get(position).getItemSubHeader());
        holder.tv_card_number.setText(mArrayList.get(position).getItemNumber());

        Log.d("MyAdapter", "position: " + position);
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_card_graphics;
        private TextView tv_card_header, tv_card_sub_header, tv_card_number;

        MyViewHolder(View view) {
            super(view);
            iv_card_graphics = view.findViewById(R.id.pop_item_image);
            tv_card_header = view.findViewById(R.id.pop_item_header);
            tv_card_sub_header = view.findViewById(R.id.pop_item_sub_header);
            tv_card_number = view.findViewById(R.id.tv_card_number);
        }
    }
}