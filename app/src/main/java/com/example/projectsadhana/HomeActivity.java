package com.example.projectsadhana;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        //String username=sharedPreferences.getString("username","").toString();
        Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();

        CardView chant=findViewById(R.id.cardChant);   //done
        chant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ChantActivity.class));
            }
        });

        CardView meditation=findViewById(R.id.cardMeditate);  //done
        meditation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newintent = new Intent(HomeActivity.this, MusicActivity.class);
                startActivity(newintent);
            }
        });

        CardView scriptures=findViewById(R.id.cardStudy);
        scriptures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(HomeActivity.this,scriptures.class);
                startActivity(intent3);
            }
        });

        CardView report=findViewById(R.id.cardSadhanaReport);
        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(HomeActivity.this,SadhanaActivity.class);
                startActivity(i);
            }
        });

        CardView darshan=findViewById(R.id.cardDieties);
        darshan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentnew=new Intent(HomeActivity.this,DarshanActivity.class);
                startActivity(intentnew);
            }
        });

        CardView logout=findViewById(R.id.logout);  //done
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(HomeActivity.this,LoginActivity.class));
            }
        });
    }
}