package com.example.firebasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class circular extends AppCompatActivity {
    ImageView ivmail,ivlibrary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circular);
        ivmail=(ImageView)findViewById(R.id.ivmail);
        ivlibrary=(ImageView)findViewById(R.id.ivlibrary);
        ivmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(circular.this, "Selected E-Circular", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(circular.this,Year.class));
            }
        });
        ivlibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(circular.this, "Selected E-Library", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(circular.this,uploadpdf.class));
            }
        });
    }
}
