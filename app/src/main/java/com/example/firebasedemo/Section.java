package com.example.firebasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Section extends AppCompatActivity {
    Button asec,bsec,csec,allsec;
    TextView textsec;
    String asecmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section);
        asec=(Button)findViewById(R.id.asec);
        bsec=(Button)findViewById(R.id.bsec);
        csec=(Button)findViewById(R.id.csec);
        allsec=(Button)findViewById(R.id.allsec);
        textsec=(TextView)findViewById(R.id.textsec);
        Intent i=getIntent();
        String year=i.getStringExtra("year");
        textsec.setText(year);
        asec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Section.this, "Circular for A-Section", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(Section.this,Mailact.class);
                if(textsec.getText().toString().equals("First Year"))
                {
                    asecmail="rgmcse1asec@gmail.com";
                }
                else if(textsec.getText().toString().equals("Second Year"))
                {
                    asecmail="rgmcse2asec@gmail.com";
                }
                else if(textsec.getText().toString().equals("Third Year"))
                {
                    asecmail="rgmcse3asec@gmail.com";
                }
                else if(textsec.getText().toString().equals("Fourth Year"))
                {
                    asecmail="rgmcse4asec@gmail.com";
                }
                i.putExtra("mailid",asecmail);
                startActivity(i);
            }
        });
        bsec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Section.this, "Circular for B-Section", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(Section.this,Mailact.class);
                if(textsec.getText().toString().equals("First Year"))
                {
                    asecmail="rgmcse1bsec@gmail.com";
                }
                else if(textsec.getText().toString().equals("Second Year"))
                {
                    asecmail="rgmcse2bsec@gmail.com";
                }
                else if(textsec.getText().toString().equals("Third Year"))
                {
                    asecmail="rgmcse3bsec@gmail.com";
                }
                else if(textsec.getText().toString().equals("Fourth Year"))
                {
                    asecmail="rgmcse4bsec@gmail.com";
                }
                i.putExtra("mailid",asecmail);
                startActivity(i);
            }
        });
        csec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Section.this, "Circular for C-Section", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(Section.this,Mailact.class);
                if(textsec.getText().toString().equals("First Year"))
                {
                    asecmail="rgmcse1csec@gmail.com";
                }
                else if(textsec.getText().toString().equals("Second Year"))
                {
                    asecmail="rgmcse2csec@gmail.com";
                }
                else if(textsec.getText().toString().equals("Third Year"))
                {
                    asecmail="rgmcse3csec@gmail.com";
                }
                else if(textsec.getText().toString().equals("Fourth Year"))
                {
                    asecmail="rgmcse4csec@gmail.com";
                }
                i.putExtra("mailid",asecmail);
                startActivity(i);
            }
        });
        allsec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Section.this, "Circular for All Sections", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(Section.this,Mailact.class);
                if(textsec.getText().toString().equals("First Year"))
                {
                    asecmail="rgmcse1asec@gmail.com,rgmcse1bsec@gmail.com,rgmcse1csec@gmail.com";
                }
                else if(textsec.getText().toString().equals("Second Year"))
                {
                    asecmail="rgmcse2asec@gmail.com,rgmcse2bsec@gmail.com,rgmcse2csec@gmail.com";
                }
                else if(textsec.getText().toString().equals("Third Year"))
                {
                    asecmail="rgmcse3asec@gmail.com,rgmcse3bsec@gmail.com,rgmcse3csec@gmail.com";
                }
                else if(textsec.getText().toString().equals("Fourth Year"))
                {
                    asecmail="rgmcse4asec@gmail.com,rgmcse4bsec@gmail.com,rgmcse4c" +
                            "sec@gmail.com";
                }
                i.putExtra("mailid",asecmail);
                startActivity(i);
            }
        });
    }
}
