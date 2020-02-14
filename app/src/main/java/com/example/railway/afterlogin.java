package com.example.railway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class afterlogin extends AppCompatActivity {
   public Button search;
public String s1,s2,s3;
public EditText from,to,date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afterlogin);
        from =findViewById(R.id.from);

         to=findViewById(R.id.to);

         date =findViewById(R.id.date);

        search=findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              searchResult();
            }
        });

    }
    public void searchResult(){
        Intent intent=new Intent(this,dataShow.class);
        s1=from.getText().toString();
        s2=to.getText().toString();
        s3=date.getText().toString();
        intent.putExtra("value",s1);
        intent.putExtra("value1",s2);
        intent.putExtra("value2",s3);

        startActivity(intent);



    }
}
