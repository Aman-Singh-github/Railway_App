package com.example.railway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private Button button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         button1=  findViewById(R.id.button1);
         final TextView signup=findViewById(R.id.signup);
         signup.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 signUp();

             }
         });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPressed();
            }
        });

    }

    private void buttonPressed() {
        Intent intent = new Intent(this, afterlogin.class);
        startActivity(intent);
    }
    private  void signUp(){
        Intent intent = new Intent(this, signup.class);
        startActivity(intent);
    }


}
