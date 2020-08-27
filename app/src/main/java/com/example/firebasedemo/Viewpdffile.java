package com.example.firebasedemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Viewpdffile extends AppCompatActivity {
    ListView pdflist;
    DatabaseReference databaseReference;
    List<loadpdf> mylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpdffile);
        pdflist=(ListView)findViewById(R.id.pdflist);
        mylist=new ArrayList<>();
        viewallpdfs();
        pdflist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                loadpdf load=mylist.get(position);
                Intent intent=new Intent(Intent.ACTION_VIEW);
                String pdfurl=load.getUrl();
                intent.setDataAndType(Uri.parse(pdfurl),"application/pdf");
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                Intent newintent=Intent.createChooser(intent,"Open File");
                try
                {
                    startActivity(newintent);
                }
                catch (ActivityNotFoundException e)
                {
                    Toast.makeText(Viewpdffile.this, "Please Install a PDF reader to view the file", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void viewallpdfs() {
        databaseReference= FirebaseDatabase.getInstance().getReference("uploads");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot: dataSnapshot.getChildren())
                {
                    loadpdf load = postSnapshot.getValue(com.example.firebasedemo.loadpdf.class);
                    mylist.add(load);
                }
                String[] uploads=new String[mylist.size()];
                for (int i=0;i<uploads.length;i++)
                {
                    uploads[i]=mylist.get(i).getName();
                }
                ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,uploads){
                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        View view=super.getView(position, convertView, parent);
                        TextView mytext=(TextView)view.findViewById(android.R.id.text1);
                        mytext.setTextColor(Color.BLACK);
                        return view;
                    }
                };
                pdflist.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Viewpdffile.this, "Failed to open", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
