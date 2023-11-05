package com.MaverickAllies.SpaceLabsTask;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityRegister extends AppCompatActivity {
    EditText etUser,etPWD,etRepwd;
    Button btnRegister,btnGoToLogin;
    DBHelper dbHelper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etUser = findViewById(R.id.username);
        etPWD  = findViewById(R.id.pass1);
        etRepwd = findViewById(R.id.pass2);
        btnRegister = findViewById(R.id.button);
        dbHelper = new DBHelper(this);
        btnGoToLogin = findViewById(R.id.button1);
        btnGoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityRegister.this , ActivityLogin.class);
                startActivity(intent);
                finish();
            }
        });


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user,pwd,repwd;
                user = etUser.getText().toString();
                pwd = etPWD.getText().toString();
                repwd = etRepwd.getText().toString();
                if(user.equals("") || pwd.equals("") || repwd.equals("")){
                    Toast.makeText(ActivityRegister.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(pwd.equals(repwd)){
                        if(dbHelper.checkUsername(user)){
                            Toast.makeText(ActivityRegister.this, "User Already exists", Toast.LENGTH_SHORT).show();
                            return;
                        }
                       boolean registeredSuccess = dbHelper.insertData(user,pwd);
                       if(registeredSuccess){
                           Toast.makeText(ActivityRegister.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
                       }
                       else
                           Toast.makeText(ActivityRegister.this, "User Registration Failed", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(ActivityRegister.this, "Password do not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
}
