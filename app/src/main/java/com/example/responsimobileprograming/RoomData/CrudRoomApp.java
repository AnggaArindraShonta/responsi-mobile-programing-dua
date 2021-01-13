package com.example.responsimobileprograming.RoomData;

import android.app.Application;

import androidx.room.Room;

import com.example.responsimobileprograming.RoomData.db.AppDatabase;
import com.example.responsimobileprograming.RoomData.db.DataBaseMigrations;

public class CrudRoomApp extends Application {

    private static CrudRoomApp INSTANCE;
    private AppDatabase dataBase;

    public static CrudRoomApp getInstance() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        dataBase = Room.databaseBuilder(this, AppDatabase.class, "database_mahasiswa")
                .addMigrations(DataBaseMigrations.MIGRATION_1_TO_2)
                .allowMainThreadQueries()
                .build();

        INSTANCE = this;
    }

    public AppDatabase getDataBase() {
        return dataBase;
    }

}
