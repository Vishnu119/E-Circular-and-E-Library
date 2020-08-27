package com.example.firebasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Year extends AppCompatActivity {
    Button one,two,three,four;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year);
        one=(Button)findViewById(R.id.one);
        two=(Button)findViewById(R.id.two);
        three=(Button)findViewById(R.id.three);
        four=(Button)findViewById(R.id.four);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Year.this, "Circular for First Year...", Toast.LENGTH_SHORT).show();
                String year=one.getText().toString();
                Intent i = new Intent(Year.this,Section.class);
                i.putExtra("year",year);
                startActivity(i);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Year.this, "Circular for Second Year...", Toast.LENGTH_SHORT).show();
                String year=two.getText().toString();
                Intent i = new Intent(Year.this,Section.class);
                i.putExtra("year",year);
                startActivity(i);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Year.this, "Circular for Third Year...", Toast.LENGTH_SHORT).show();
                String year=three.getText().toString();
                Intent i = new Intent(Year.this,Section.class);
                i.putExtra("year",year);
                startActivity(i);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Year.this, "Circular for Fourth Year...", Toast.LENGTH_SHORT).show();
                String year=four.getText().toString();
                Intent i = new Intent(Year.this,Section.class);
                i.putExtra("year",year);
                startActivity(i);
            }
        });
    }
}
