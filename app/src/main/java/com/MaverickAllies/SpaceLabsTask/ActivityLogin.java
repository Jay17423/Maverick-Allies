package com.MaverickAllies.SpaceLabsTask;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityLogin extends AppCompatActivity {
    DBHelper dbHelper;
    Button btnLogin;
    EditText etUsername, etPwd;
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        etUsername = findViewById(R.id.username);
        etPwd  = findViewById(R.id.pass);
        btnLogin = findViewById(R.id.loginbtn);
        dbHelper = new DBHelper(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isLoggedId = dbHelper.checkUser(etUsername.getText().toString(), etPwd.getText().toString());

                if(isLoggedId){
                    Intent intent = new Intent(ActivityLogin.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                    Toast.makeText(ActivityLogin.this, "Login Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
