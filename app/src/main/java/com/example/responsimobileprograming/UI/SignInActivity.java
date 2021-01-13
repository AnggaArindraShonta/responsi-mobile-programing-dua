package com.example.responsimobileprograming.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.responsimobileprograming.R;
import com.example.responsimobileprograming.SharedPreference.SharedPrefManager;

public class SignInActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    private TextView txtsignup;
    private EditText etemail;
    private EditText etpassword;
    private Button btn_signin;
    private SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        etemail = findViewById(R.id.email);
        etpassword = findViewById(R.id.password);
        btn_signin = findViewById(R.id.btn_signin);
        sharedPrefManager= new SharedPrefManager(this);
        txtsignup= (TextView)findViewById(R.id.txtsignup);

        txtsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        login();

    }

    private void login() {
        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = etemail.getText().toString();
                final String password = etpassword.getText().toString();

                if (email.isEmpty() || password.isEmpty()){
                    Toast.makeText(SignInActivity.this, "Email dan password salah :)", Toast.LENGTH_SHORT).show();
                }else{
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            String spEmail = sharedPrefManager.getEmail();
                            String spPassword = sharedPrefManager.getPassword();

                            if (email.equals(spEmail) && password.equals(spPassword)){
                                Intent i = new Intent(SignInActivity.this, MainActivity.class);
                                sharedPrefManager.saveIsLogin(true);
                                finishAffinity();
                                startActivity(i);
                            }else {
                                Toast.makeText(SignInActivity.this, "Email dan Password Salah :)", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, 3000);
                }
            }
        });
    }
}


