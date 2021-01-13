package com.example.responsimobileprograming.RoomData.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

    @Entity
    public class Mahasiswa {

        @PrimaryKey(autoGenerate = true)
        private int id = 0;

        @ColumnInfo(name = "email")
        private String email = "";

        @ColumnInfo(name = "nama")
        private String nama = "";

        @ColumnInfo(name = "fakultas")
        String fakultas;

        @ColumnInfo(name = "password")
        private String password = "";

        public Mahasiswa() {

        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public String getFakultas() {
            return fakultas;
        }

        public void setFakultas(String fakultas) {
            this.fakultas = fakultas;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }


