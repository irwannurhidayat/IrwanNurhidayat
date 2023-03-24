package com.example.irwannurhidayat;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder> {

    private ArrayList<ItemModel> dataItem;

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtJudul;
        TextView txtTahun;
        ImageView karyacetak;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtJudul = itemView.findViewById(R.id.txt_judul);
            txtTahun = itemView.findViewById(R.id.txt_tahun);
            karyacetak = itemView.findViewById(R.id.image_karya);

        }
    }

    AdapterRecyclerView(ArrayList<ItemModel> data){
        this.dataItem = data;
    }

    @NonNull
    @Override
    public AdapterRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_karya, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        TextView txt_judul = holder.txtJudul;
        TextView txt_tahun = holder.txtTahun;
        ImageView image_karya = holder.karyacetak;

        txt_judul.setText(dataItem.get(position).getNamejd());
        txt_tahun.setText(dataItem.get(position).getYear());
        image_karya.setImageResource(dataItem.get(position).getKarya());

    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
