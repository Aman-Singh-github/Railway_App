package com.example.railway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class signup extends AppCompatActivity {
    private Button signupNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signupNext=findViewById(R.id.signupNext);
        signupNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signupDone();
            }
        });

    }
    private void signupDone(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}
