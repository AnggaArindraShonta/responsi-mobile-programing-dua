package com.example.responsimobileprograming.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.responsimobileprograming.R;
import com.example.responsimobileprograming.RoomData.Model.Mahasiswa;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context mContext;
    private List<Mahasiswa> albumList;
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView email, nama, fakultas, password;
        public MyViewHolder(View v) {
            super(v);

            email = v.findViewById(R.id.tvEmail);
            nama = v.findViewById(R.id.tvNama);
            fakultas = v.findViewById(R.id.tvFakultas);
            password = v.findViewById(R.id.tvPassword);
        }
    }
    public RecyclerViewAdapter (Context mContext,List<Mahasiswa>albumList){
        this.mContext = mContext;
        this.albumList = albumList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_mahasiswa, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Mahasiswa album = albumList.get(position);
        holder.email.setText(album.getEmail());
        holder.nama.setText(album.getNama());
        holder.fakultas.setText(album.getFakultas());
        holder.password.setText(album.getPassword());
    }


    @Override
    public int getItemCount() {
        return albumList.size();
    }
}

