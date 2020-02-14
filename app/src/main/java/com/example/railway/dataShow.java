package com.example.railway;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class dataShow extends AppCompatActivity {
    private TextView result;
    private RequestQueue mQueue;
public String s1,s2,s3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_show);
        result = findViewById(R.id.result);
        Button parse = findViewById(R.id.parse);
        Button total=findViewById(R.id.total);
        s1=getIntent().getExtras().getString("value");
        s2=getIntent().getExtras().getString("value1");
        s3=getIntent().getExtras().getString("value2");
        mQueue = Volley.newRequestQueue(this);
        parse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });
        total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonTotal();
            }
        });
    }

    private void jsonParse() {
        String url = "https://api.railwayapi.com/v2/between/source/"+s1+"/dest/"+s2+"/date/"+s3+"/apikey/2pi53tnzwn/";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("trains");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject trains = jsonArray.getJSONObject(i);
                                String name = trains.getString("name");
                                result.append(name+"\n\n");
                            }
                        } catch (JSONException e) {
                            Toast.makeText(dataShow.this, "error in catch",
                                    Toast.LENGTH_LONG).show();
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(dataShow.this, "error in volley",
                        Toast.LENGTH_LONG).show();
                error.printStackTrace();
            }
        });
        mQueue.add(request);
    }
    public void jsonTotal(){
        String url = "https://api.railwayapi.com/v2/between/source/"+s1+"/dest/"+s2+"/date/"+s3+"/apikey/2pi53tnzwn/";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("total");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject total = jsonArray.getJSONObject(i);
                                String totals = total.getString("total");
                                result.append(totals);
                            }
                        } catch (JSONException e) {
                            Toast.makeText(dataShow.this, "error in catch",
                                    Toast.LENGTH_LONG).show();
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(dataShow.this, "error in volley",
                        Toast.LENGTH_LONG).show();
                error.printStackTrace();
            }
        });
    }
}
