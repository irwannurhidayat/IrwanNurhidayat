package com.example.irwannurhidayat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.irwannurhidayat.api.ApiClient;
import com.example.irwannurhidayat.api.ApiInterface;
import com.example.irwannurhidayat.model.login.Login;
import com.example.irwannurhidayat.model.login.LoginData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView etusername, etpassword;
    Button loginbtn;

    String username, password;
    TextView tvregister;

    ApiInterface apiInterface;

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etusername = findViewById(R.id.etusername);
        etpassword = findViewById(R.id.etpassword);
        loginbtn = findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(this);

        tvregister = findViewById(R.id.tvbuatakun);
        tvregister.setOnClickListener(this);
        }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loginbtn:
                username = etusername.getText().toString();
                password = etpassword.getText().toString();
                login(username, password);
                break;
            case R.id.tvbuatakun:
                Intent intent = new Intent(this,Register.class);
                startActivity(intent);
                break;
         }
    }

    private void login(String username, String password) {

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Login> loginCall = apiInterface.loginResponse(username, password);
        loginCall.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if (response.body() != null && response.isSuccessful() && response.body().isStatus()) {

                    //ini untuk menyimpan session
                    sessionManager = new SessionManager(MainActivity.this);
                    LoginData loginData = response.body().getData();
                    sessionManager.createLoginSession(loginData);

                    //ini untuk pindah
                    Toast.makeText(MainActivity.this, response.body().getData().getName(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Home.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
}