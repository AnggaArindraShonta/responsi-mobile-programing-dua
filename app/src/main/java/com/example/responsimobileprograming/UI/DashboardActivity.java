package com.example.responsimobileprograming.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.responsimobileprograming.RoomData.Model.Mahasiswa;
import com.example.responsimobileprograming.R;
import com.example.responsimobileprograming.RoomData.CrudRoomApp;

public class DashboardActivity extends AppCompatActivity {

    EditText etEmail;
    EditText etNama;
    EditText etFakultas;
    EditText etPassword;
    Mahasiswa mahasiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Button btnSimpan = findViewById(R.id.btInsert);
        etEmail = findViewById(R.id.etEmail);
        etNama = findViewById(R.id.etNama);
        etFakultas = findViewById(R.id.etFakultas);
        etPassword = findViewById(R.id.etPassword);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tambahData();
            }
        });
    }

    private void tambahData() {
        if (!etEmail.getText().toString().isEmpty() && !etNama.getText().toString().isEmpty() &&
                !etFakultas.getText().toString().isEmpty() && !etPassword.getText().toString().isEmpty()) {

            mahasiswa = new Mahasiswa();
            mahasiswa.setEmail(etEmail.getText().toString());
            mahasiswa.setNama(etNama.getText().toString());
            mahasiswa.setFakultas(etFakultas.getText().toString());
            mahasiswa.setPassword(etPassword.getText().toString());


            CrudRoomApp.getInstance().getDataBase().userDao().insertAll(mahasiswa);
            startActivity(new Intent(DashboardActivity.this, ProfilActivity.class));
        } else {
            Toast.makeText(this, "Mohon masukkan dengan benar", Toast.LENGTH_SHORT).show();
        }
    }
}


