package com.example.firebasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnenter;
    TextView tvstaff,tvstudent;
    ImageView ivstaff,ivstudent;
    EditText etpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnenter=(Button)findViewById(R.id.btnenter);
        tvstaff=(TextView)findViewById(R.id.tvstaff);
        tvstudent=(TextView)findViewById(R.id.tvstudent);
        ivstaff=(ImageView)findViewById(R.id.ivstaff);
        ivstudent=(ImageView)findViewById(R.id.ivstudent);
        etpassword=(EditText)findViewById(R.id.etpassword);
        ivstaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvstudent.setVisibility(View.GONE);
                ivstudent.setVisibility(View.GONE);
                etpassword.setVisibility(View.VISIBLE);
                btnenter.setVisibility(View.VISIBLE);
            }
        });
        ivstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvstaff.setVisibility(View.GONE);
                ivstaff.setVisibility(View.GONE);
                etpassword.setVisibility(View.VISIBLE);
                btnenter.setVisibility(View.VISIBLE);
            }
        });
        btnenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userpass=etpassword.getText().toString();
                if(userpass.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please enter the User password...", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(userpass.equals("rgmstaff"))
                    {
                        Toast.makeText(MainActivity.this, "Welcome user...", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this,Loginact.class));
                        finish();
                    }
                    else if(userpass.equals("rgmstudent"))
                    {
                        Toast.makeText(MainActivity.this, "Welcome user...", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this,uploadpdf.class));
                        finish();
                    }
                }
            }
        });
    }
}
