package com.example.responsimobileprograming.RoomData.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.responsimobileprograming.RoomData.Model.Mahasiswa;
import com.example.responsimobileprograming.RoomData.dao.MahasiswaDao;

@Database(entities = {Mahasiswa.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MahasiswaDao userDao();
}
