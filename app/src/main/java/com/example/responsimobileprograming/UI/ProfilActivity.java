package com.example.responsimobileprograming.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.responsimobileprograming.Adapter.RecyclerViewAdapter;
import com.example.responsimobileprograming.R;
import com.example.responsimobileprograming.RoomData.CrudRoomApp;
import com.example.responsimobileprograming.RoomData.Model.Mahasiswa;

import java.util.ArrayList;
import java.util.List;

import static com.example.responsimobileprograming.RoomData.db.MyApp.db;

public class ProfilActivity extends AppCompatActivity {
    RecyclerView myRecyclerview;
    RecyclerViewAdapter recycleAdapter;
    List<Mahasiswa> listMahasiswas = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        myRecyclerview = findViewById(R.id.myRecyclerview);

        fetchDataFromRoom();
        initRecyclerView();
        setAdapter();
    }

    private void fetchDataFromRoom() {
        db = CrudRoomApp.getInstance().getDataBase();
        listMahasiswas = db.userDao().getAll();

        //just checking data from db
        for (int i = 0 ;i <listMahasiswas.size();i++){
            Log.e("Aplikasi",listMahasiswas.get(i).getEmail()+i);
            Log.e("Aplikasi",listMahasiswas.get(i).getNama()+i);
            Log.e("Aplikasi",listMahasiswas.get(i).getFakultas()+i);
            Log.e("Aplikasi",listMahasiswas.get(i).getPassword()+i);
        }
    }
    private void initRecyclerView() {
        myRecyclerview.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        myRecyclerview.setLayoutManager(llm);
        recycleAdapter = new RecyclerViewAdapter(this,listMahasiswas);
    }
    private void setAdapter() {
        myRecyclerview.setAdapter(recycleAdapter);
    }
}