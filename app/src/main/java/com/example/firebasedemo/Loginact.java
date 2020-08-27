package com.example.firebasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Loginact extends AppCompatActivity {
    EditText etmail,etpassword;
    Button btnlogin,btnregister;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginact);
        etmail=(EditText)findViewById(R.id.etmail);
        etpassword=(EditText)findViewById(R.id.etpassword);
        btnlogin=(Button)findViewById(R.id.btnlogin);
        btnregister=(Button)findViewById(R.id.btnregister);
        auth=FirebaseAuth.getInstance();
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=etmail.getText().toString();
                String password=etpassword.getText().toString();
                if(email.equals("")||password.equals(""))
                {
                    Toast.makeText(Loginact.this, "Fields should not leave empty!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    loginuser(email,password);
                }
            }
        });
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Loginact.this,Registeract.class));
            }
        });
    }

    private void loginuser(String email, String password) {
        auth.signInWithEmailAndPassword(email,password).addOnSuccessListener(Loginact.this, new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {

                Toast.makeText(Loginact.this, "Logged In Successfully...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Loginact.this,circular.class));
            }
        });
    }
}
