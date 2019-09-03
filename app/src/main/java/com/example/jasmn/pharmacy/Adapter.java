package com.example.jasmn.pharmacy;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.holder>  {
private List<pharmacy> list;
private Context context;

    public Adapter(List<pharmacy> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.ph_view, viewGroup,false);
        holder holder=new holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int i) {
         final pharmacy pharmacy=list.get(i);
           holder.imageView.setImageResource(pharmacy.getPicture());
           holder.name_.setText(pharmacy.getPh_name());
           holder.phone_.setText(pharmacy.getPhone());
           holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {

                   Uri uri = Uri.parse("google.navigation:q=" + pharmacy.getLatitude() + "," + pharmacy.getLongtitude());
                   Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                   intent.setPackage("com.google.android.apps.maps");
                   context.startActivity(intent);


               }
           });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class holder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name_,phone_;
        ConstraintLayout constraintLayout;
        public holder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            name_=itemView.findViewById(R.id.name);
            phone_=itemView.findViewById(R.id.phone);
            constraintLayout=itemView.findViewById(R.id.consta);

        }


    }
}
