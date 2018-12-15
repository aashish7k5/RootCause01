package com.example.aashishkumar.rootcause01;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Code forked from/inspired by Parsania Hardik on GitHub.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<Model> imageModelArrayList;


    public Adapter(Context ctx, ArrayList<Model> imageModelArrayList){

        inflater = LayoutInflater.from(ctx);
        this.imageModelArrayList = imageModelArrayList;
    }

    @Override
    public Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.rv_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(Adapter.MyViewHolder holder, int position) {

        holder.ic.setImageResource(imageModelArrayList.get(position).getImage_drawable());
        holder.text1.setText(imageModelArrayList.get(position).getText1());
        holder.text2.setText(imageModelArrayList.get(position).getText2());
        holder.mode.setText(imageModelArrayList.get(position).getMode());
    }

    @Override
    public int getItemCount() {
        return imageModelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView text1, text2, mode;
        ImageView ic;

        public MyViewHolder(View itemView) {
            super(itemView);

            text1 = (TextView) itemView.findViewById(R.id.info_text1);
            text2 = (TextView) itemView.findViewById(R.id.info_text2);
            mode = (TextView) itemView.findViewById(R.id.mode);
            ic = (ImageView) itemView.findViewById(R.id.ic);
        }

    }
}

