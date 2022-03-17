package com.example.kawach.ui.home;

import android.content.pm.ApplicationInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kawach.R;
import com.example.kawach.data.applistdata;

import java.text.CollationElementIterator;
import java.util.List;

public class applist_recyclerview extends RecyclerView.Adapter <applist_recyclerview.ViewHolder> {
    private applistdata[] applist_data;
    public applist_recyclerview(applistdata[] applist_data){
        this.applist_data=applist_data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.content_single_app_recyclerview_model, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,final int position) {
        final applistdata myListData = applist_data[position];
        holder.textView.setText(applist_data[position].getDescription());
        holder.imageView.setImageDrawable(applist_data[position].getImgId());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"click on item: "+myListData.getDescription(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return applist_data.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView textView;
        public RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.app_image);
            this.textView = (TextView) itemView.findViewById(R.id.app_name);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relativeLayout);      }
}
}
