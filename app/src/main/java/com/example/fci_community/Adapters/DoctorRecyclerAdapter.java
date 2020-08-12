package com.example.fci_community.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fci_community.Firebase.PostItems;
import com.example.fci_community.R;

import java.util.List;

public class DoctorRecyclerAdapter extends RecyclerView.Adapter<DoctorRecyclerAdapter.MyViewHolder> {

    Context mContext;
    List<PostItems> postItemsList;

    public DoctorRecyclerAdapter(Context mContext, List<PostItems> postItemsList) {
        this.mContext = mContext;
        this.postItemsList = postItemsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(mContext).inflate(R.layout.fragment_doctor_post_recycler,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final PostItems postItems=postItemsList.get(position);

        holder.textViewRecycler.setText(postItemsList.get(position).getPostText());
        //Glide.with(mContext).load(postItemsList.get(position).getPostPhoto()).into(holder.imageViewRecycler);
        holder.textViewTime.setText(postItemsList.get(position).getFormattedTime());

        if ((postItemsList.get(position).getPostPhoto()).equals(null))
        {
            holder.imageViewRecycler.setVisibility(View.GONE);
        }
        else if(!postItems.getPostPhoto().isEmpty())
        {
            holder.imageViewRecycler.setVisibility(View.VISIBLE);
            Glide.with(mContext).load(postItems.getPostPhoto()).into(holder.imageViewRecycler);

        }

    }

    @Override
    public int getItemCount() {
        return postItemsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewRecycler,textViewTime;
        ImageView imageViewRecycler;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewRecycler=itemView.findViewById(R.id.text_recyclerPost);
            imageViewRecycler=itemView.findViewById(R.id.image_recyclerPost);
            textViewTime=itemView.findViewById(R.id.text_tim);
        }
    }
}
