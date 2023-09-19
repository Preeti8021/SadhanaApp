package com.example.projectsadhana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class DarshanActivity extends AppCompatActivity {
    ListView l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_darshan);
        l = findViewById(R.id.listview);

        List<String> list=new ArrayList<>();
        list.add("Sri Krishna Balaram, Vrindavan");
        list.add("Sri Radha ShyamSundar, Vrindavan");
        list.add( "Jagannatha Swami, Puri");
        list.add("Shree Dwarakadhish, Dwaraka");
        list.add("Banke Bihari, Vrindavan");
        list.add("Shri Vitthal Rukmini mandir, Pandharpur");
        list.add("Narasimha Deva");
        list.add("Shree Radha Raman");
        list.add("Tirupathi Balaji");
        list.add("Gaura Nitai");
        list.add("Udupi Krishna");
        list.add("Ranganatha Swami");
        list.add("Simhachalam Swami");
        ArrayAdapter<String> adapter=new ArrayAdapter<>(DarshanActivity.this,android.R.layout.simple_list_item_1,list);
        l.setAdapter(adapter);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent i1=new Intent(DarshanActivity.this, trial.class);
                    startActivity(i1);
                } else if (position==1) {
                    Intent i2=new Intent(DarshanActivity.this, radhashyamsundar.class);
                    startActivity(i2);
                }
                else if (position==2){
                    Intent i3=new Intent(DarshanActivity.this, jagannatha.class);
                    startActivity(i3);
                }
                else if (position==3){
                    Intent i4=new Intent(DarshanActivity.this, dwarakadheesh.class);
                    startActivity(i4);
                }
                else if (position==4){
                    Intent i5=new Intent(DarshanActivity.this, bankebihari.class);
                    startActivity(i5);
                }
                else if (position==5){
                    Intent i6=new Intent(DarshanActivity.this, vitthalrukmini.class);
                    startActivity(i6);
                }
                else if (position==6){
                    Intent i7=new Intent(DarshanActivity.this, narasimhadeva.class);
                    startActivity(i7);
                }
                else if (position==7){
                    Intent i8=new Intent(DarshanActivity.this, radharaman.class);
                    startActivity(i8);
                }
                else if (position==8){
                    Intent i9=new Intent(DarshanActivity.this, balaji.class);
                    startActivity(i9);
                }
                else if (position==9){
                    Intent i10=new Intent(DarshanActivity.this, gauranitai.class);
                    startActivity(i10);
                }
                else if (position==10){
                    Intent i11=new Intent(DarshanActivity.this, udupikrishna.class);
                    startActivity(i11);
                }
                else if (position==11){
                    Intent i12=new Intent(DarshanActivity.this, ranganathaswamy.class);
                    startActivity(i12);
                }
                else if (position==12){
                    Intent i13=new Intent(DarshanActivity.this, simhachalam.class);
                    startActivity(i13);
                }
            }
        });
    }
}