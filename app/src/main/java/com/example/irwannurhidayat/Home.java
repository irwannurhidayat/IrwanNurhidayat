package com.example.irwannurhidayat;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    Button exitButton;
    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    exitButton = findViewById(R.id.buttonexit);
    builder = new AlertDialog.Builder(this);

    exitButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title);

        builder.setMessage("are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    finish();
                        Toast.makeText(Home.this,"You choose yes action for alert box", Toast.LENGTH_SHORT);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        Toast.makeText(Home.this, "You choose no action for alert box", Toast.LENGTH_SHORT);
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.setTitle("Exit");
        alertDialog.show();

        }
    });
    }
}