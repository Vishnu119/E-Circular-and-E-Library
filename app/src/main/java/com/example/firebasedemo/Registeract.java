package com.example.firebasedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registeract extends AppCompatActivity {
    EditText etmail, etpassword, etreenter;
    Button btnregister;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeract);
        etmail = (EditText) findViewById(R.id.etmail);
        etpassword = (EditText) findViewById(R.id.etpassword);
        etreenter = (EditText) findViewById(R.id.etreenter);
        btnregister = (Button) findViewById(R.id.btnregister);
        auth = FirebaseAuth.getInstance();
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etmail.getText().toString();
                String password = etpassword.getText().toString();
                String reenter = etreenter.getText().toString();
                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(reenter)) {
                    Toast.makeText(Registeract.this, "Fields should not leave empty!", Toast.LENGTH_SHORT).show();
                } else if (password.equals(reenter) == false) {
                    Toast.makeText(Registeract.this, "Password and Re-entered password should match!", Toast.LENGTH_SHORT).show();
                } else if (password.length() < 6) {
                    Toast.makeText(Registeract.this, "Password too short!", Toast.LENGTH_SHORT).show();
                } else {
                    registeruser(email, password);
                }
            }
        });
    }

    private void registeruser(String email, String password) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(Registeract.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(Registeract.this, "Successfully registered...", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Registeract.this,Loginact.class));
                    finish();
                }
                else
                {
                    Toast.makeText(Registeract.this, "Registration Failed...", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

