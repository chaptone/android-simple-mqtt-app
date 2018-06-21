package com.example.chapmac.rakkan.mqtt_app_test.Home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chapmac.rakkan.mqtt_app_test.R;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeViewHolder> {

    private ArrayList<HomeItem> homeList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
        void onDeleteClick(int position);
    }

    public void setOnCilckItemListener(OnItemClickListener listener){
        mListener = listener;
    }



    public HomeAdapter(ArrayList<HomeItem> homeItems){
        homeList = homeItems;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_home_item,parent,false);
        HomeViewHolder homeViewHolder = new HomeViewHolder(view,mListener);
        return homeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        HomeItem currentItem = homeList.get(position);

        holder.textView.setText(currentItem.getTopic());
        holder.textView1.setText(currentItem.getMessage());
    }

    @Override
    public int getItemCount() {
        return homeList.size();
    }

}