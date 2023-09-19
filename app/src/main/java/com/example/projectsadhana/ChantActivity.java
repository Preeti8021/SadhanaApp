package com.example.projectsadhana;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ChantActivity extends AppCompatActivity {
    private Button movableButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chant);

        movableButton = findViewById(R.id.chant);
        Button resetButton = findViewById(R.id.reset);

        movableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = movableButton.getText().toString();
                int p = Integer.parseInt(a);
                int c = p + 1;
                movableButton.setText(String.valueOf(c));
                if(c==108){
                    movableButton.setText("0");
                }
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movableButton.setText("0");
            }
        });

    }
}
