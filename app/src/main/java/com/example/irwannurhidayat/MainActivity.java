package com.example.irwannurhidayat;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView username = (TextView) findViewById(R.id.txtUser);
        TextView password = (TextView) findViewById(R.id.txtpassword);

        Button login = (Button) findViewById(R.id.loginbtn);


        //admin and admin

        login.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if(username.getText().toString().equals("irwan") && password.getText().toString().equals("irwan")) {
                //correct
                    startActivity(new Intent(MainActivity.this,Home.class));
                    Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
                }else
                //incorrect
                    Toast.makeText(MainActivity.this,"Login Failed!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}