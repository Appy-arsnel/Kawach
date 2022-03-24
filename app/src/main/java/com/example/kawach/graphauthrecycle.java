package com.example.kawach;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kawach.data.gimglist;

import java.util.List;

public class graphauthrecycle extends RecyclerView.Adapter<graphauthrecycle.ViewHolder>{
    List<gimglist> glist;
    String passwprd;
    public graphauthrecycle(List<gimglist> glist) {
        this.glist = glist;
    }

    @NonNull
    @Override
    public graphauthrecycle.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.content_graphical_pass_auth_images, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull graphauthrecycle.ViewHolder holder, int position) {
        final gimglist myListData = glist.get(holder.getAdapterPosition());
        passwprd=passwprd+myListData.getId().toString();
        holder.imageView=myListData.getImgId();
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.isselected=true)


            }
        });
        }

    @Override
    public int getItemCount() {
        return glist.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        boolean isselected=false;
        public ViewHolder(View itemview) {

            super(itemview);


            imageView = (ImageView) itemView.findViewById(R.id.gimage);


        }
    }
}
