package com.example.irwannurhidayat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity implements View.OnClickListener{

    SessionManager sessionManager;
    TextView etusername, etname, tvobject1;
    String username, name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sessionManager = new SessionManager(Home.this);
        if (!sessionManager.isLoggedIn()) {
            moveToLogin();
        }

        etusername = findViewById(R.id.etMainUsername);
        etname = findViewById(R.id.etMainname);

        username = sessionManager.getUserDetail().get(SessionManager.USERNAME);
        name = sessionManager.getUserDetail().get(SessionManager.NAME);

        etusername.setText(username);
        etname.setText(name);

        tvobject1 = findViewById(R.id.tvObject1);
        tvobject1.setOnClickListener(this);


    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tvObject1) {
            Intent intent = new Intent(Home.this, Karya.class);
            startActivity(intent);
        }
    }


    private void moveToLogin() {

        Intent intent = new Intent(Home.this, MainActivity.class);
        //agar data di main activity menjadi kosong
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }

    @Override
    public  boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.actionLogout:
                sessionManager.logoutSession();
                moveToLogin();
        }
        return  super.onOptionsItemSelected(item);
    }


}

