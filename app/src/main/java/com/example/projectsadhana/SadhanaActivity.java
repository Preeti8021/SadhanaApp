package com.example.projectsadhana;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SadhanaActivity extends AppCompatActivity {
    EditText rounds,wakeup,study;
    Button save,viewall;
    TextView output;
    databasehelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sadhana);
        rounds = findViewById(R.id.tvrounds);
        wakeup = findViewById(R.id.tvwakeup);
        study = findViewById(R.id.tvstudytime);
        save =findViewById(R.id.savebtn);
        viewall=findViewById(R.id.viewallbtn);
        output=findViewById(R.id.tvlist);
        db=new databasehelper(SadhanaActivity.this,"Report",null,1);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String roundschanted=rounds.getText().toString();
                String wakeuptime=wakeup.getText().toString();
                String studytime= study.getText().toString();
                long recordid=db.saveNewUserData(roundschanted,wakeuptime,studytime);//called our method
                if(recordid>0){
                    Toast.makeText(getApplicationContext(),"Saved successfully",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Saved successfully",Toast.LENGTH_SHORT).show();
                }
            }
        });

        viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String results=db.getAllRecords();
               output.setText(results);
            }
        });
    }
}
