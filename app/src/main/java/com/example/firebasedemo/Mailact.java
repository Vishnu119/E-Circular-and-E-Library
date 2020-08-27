package com.example.firebasedemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Mailact extends AppCompatActivity {
    EditText etsubject,etmessage,etmail;
    Button btnattach,btnsend;
    String mail;
    Uri u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mailact);
        Intent i=getIntent();
        mail=i.getStringExtra("mailid");
        etmail=(EditText) findViewById(R.id.etmail);
        etsubject=(EditText)findViewById(R.id.etsubject);
        etmessage=(EditText)findViewById(R.id.etmessage);
        btnattach=(Button)findViewById(R.id.btnattach);
        btnsend=(Button)findViewById(R.id.btnsend);
        etmail.setText(mail);
        btnattach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                startActivityForResult(intent,111);
            }
        });
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                //String tomail=etmail.getText().toString();
                String[] recipients=mail.split(",");
                String subject=etsubject.getText().toString();
                String msg=etmessage.getText().toString();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL,recipients);
                intent.putExtra(Intent.EXTRA_SUBJECT,subject);
                intent.putExtra(Intent.EXTRA_TEXT,msg);
                intent.putExtra(Intent.EXTRA_STREAM,u);
                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent,"Choose the client"));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==111&&resultCode==RESULT_OK)
        {
            u=data.getData();
        }
    }
}
