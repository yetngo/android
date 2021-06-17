package com.yetngo289.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String st1[], st2[];
    int image[];
    Context context;

    public MyAdapter(Context c, String s1[], String s2[], int img[]) {
        context = c;
        st1 = s1;
        st2 = s2;
        image = img;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        for (int i = 0; i < st1.length; i++) {
            System.out.println("s1="+st1[i]);
        }
        for (int i = 0; i < image.length; i++) {
            System.out.println("s="+image[i]);
        }
        holder.mytext.setText(st1[position]);
        holder.mytext2.setText(st2[position]);
        holder.myImg.setImageResource(image[position]);
    }

    @Override
    public int getItemCount() {
        System.out.println("s=" + image.length);
        return image.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mytext, mytext2;
        ImageView myImg;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mytext = itemView.findViewById(R.id.textView);
            mytext2 = itemView.findViewById(R.id.textView2);
            myImg = itemView.findViewById(R.id.imageView);
        }

    }
}
