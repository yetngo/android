package com.yetngo289.recyclerviewtest;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<Product> products;
    Context context;

    public MyAdapter(Context c, ArrayList<Product> product) {
        context = c;
        products = product;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        Product product = products.get(position);
        holder.rowMsp.setText("Mã SP: " + product.getMasp());
        holder.rowGiatien.setText("Giá tiền: " + product.getGiatien());

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, InfoActivity.class);
                intent.putExtra("msp", product.getMasp());
                intent.putExtra("tensp", product.getTensp());
                intent.putExtra("mota", product.getMota());
                intent.putExtra("gia", product.getGiatien());
                context.startActivity(intent);
            }
        });
//                "Tên SP: "+product.getTensp()+"\n\n"
//                            +"Mô tả: "+product.getMota()+"\n\n"
//                            +

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView rowMsp, rowGiatien;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            rowMsp = itemView.findViewById(R.id.tv_rowMsp);
            rowGiatien = itemView.findViewById(R.id.tv_rowGiaTien);
            mainLayout = itemView.findViewById(R.id.mainLayout);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
////                    Toast.makeText(v,rowMsp,Toast.LENGTH_SHORT).show();
//                }
//            });
        }

    }
}

