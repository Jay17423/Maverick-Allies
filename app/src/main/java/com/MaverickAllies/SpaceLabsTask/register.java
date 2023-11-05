package com.MaverickAllies.SpaceLabsTask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class register extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText username = findViewById(R.id.username);
        EditText emailid = findViewById(R.id.emailid);
        EditText password = findViewById(R.id.pass1);
        EditText confirmpassword = findViewById(R.id.pass2);
       CheckBox box = findViewById(R.id.checkBox);
       Button btn = findViewById(R.id.button);
       Button btn1 =findViewById(R.id.button1);
       TextView title = findViewById(R.id.Welcome);

//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!password.getText().toString().equals(confirmpassword.getText().toString())) {
//                    Toast.makeText(register.this, "PASSWORD DID NOT MATCH", Toast.LENGTH_SHORT).show();
//                }
//                else
//                    Toast.makeText(register.this, "REGISTERED SUCCESSFULLY", Toast.LENGTH_SHORT).show();
//            }
//        });

        box.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Checkbox is checked, read buttons
                    btn.setEnabled(true);
                }
                else
                    btn.setEnabled(false);
                    Toast.makeText(register.this, "PLEASE ACCEPT TERMS AND CONDITION", Toast.LENGTH_SHORT).show();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), signup.class);
                startActivity(intent);
                finish();
            }
        });



    }
}