package com.example.irwannurhidayat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.irwannurhidayat.api.ApiClient;
import com.example.irwannurhidayat.api.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity implements View.OnClickListener{
    EditText etusername, etname, etpassword;
    Button registerbtn;

    String username, password, name;
    TextView login;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etusername = findViewById(R.id.etusername2);
        etname = findViewById(R.id.etname2);
        etpassword = findViewById(R.id.etpassword2);
        registerbtn = findViewById(R.id.registerbtn);
        registerbtn.setOnClickListener(this);
        login = findViewById(R.id.tvloginhere);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.registerbtn:
                username = etusername.getText().toString();
                password = etpassword.getText().toString();
                name = etname.getText().toString();
                register(username, password, name);
                break;
            case R.id.tvloginhere:
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
public static void set(){

}
    private void register(String username, String password, String name) {

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call <com.example.irwannurhidayat.model.register.Register> call = apiInterface.registerResponse(username, password, name);

        call.enqueue(new Callback<com.example.irwannurhidayat.model.register.Register>() {
            @Override
            public void onResponse(Call<com.example.irwannurhidayat.model.register.Register> call, Response<com.example.irwannurhidayat.model.register.Register> response) {
                if (response.body() != null && response.isSuccessful() && response.body().isStatus()) {
                    Toast.makeText(Register.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Register.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(Register.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<com.example.irwannurhidayat.model.register.Register> call, Throwable t) {
                Toast.makeText(Register.this,t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}