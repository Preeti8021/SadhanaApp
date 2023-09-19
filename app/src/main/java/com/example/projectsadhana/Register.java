package com.example.projectsadhana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText edusername,edpassword,edconfirmpassword,edemail;
    TextView tvalreadyhave;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edusername=findViewById(R.id.edittextregusername);
        edpassword=findViewById(R.id.edittextregpassword);
        edconfirmpassword=findViewById(R.id.edittextregconfirmpassword);
        edemail=findViewById(R.id.edittextregemail);
        tvalreadyhave=findViewById(R.id.textviewexistinguser);
        register=findViewById(R.id.registerbutton);

        tvalreadyhave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Register.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=edusername.getText().toString();
                String email=edemail.getText().toString();
                String password=edpassword.getText().toString();
                String confirm=edconfirmpassword.getText().toString();
                Database db= new Database(getApplicationContext(),"Sadhana",null,1);
                if(username.length()==0 || email.length()==0 || password.length()==0 || confirm.length()==0){
                    Toast.makeText(getApplicationContext(),"Please fill all details",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(password.compareTo(confirm)==0){
                        if(isValid(password)){
                            db.register(username,email,password);
                            Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Register.this, LoginActivity.class));
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Password must contain atleast 8 characters, having letter, digit and special symbol",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Password and confirm password didn't match",Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
    }
        public static boolean isValid(String passwordhere) {
            int f1 = 0, f2 = 0, f3 = 0;
            if (passwordhere.length() < 8) {
                return false;
            }
            else{
                for(int p=0;p<passwordhere.length();p++){
                    if(Character.isLetter((passwordhere.charAt(p)))){
                        f1=1;
                    }
                }
                for(int r=0;r<passwordhere.length();r++){
                    if(Character.isDigit(passwordhere.charAt(r))){
                        f2=1;
                    }
                }
                for(int s=0;s<passwordhere.length();s++){
                    char c=passwordhere.charAt(s);
                    if(c>=22 && c<=46 || c==64){
                        f3=1;
                    }
                }
                if(f1==1 && f2==1 && f3==1){
                    return true;
                }
            }
            return false;
        }
}
