package com.machmoum.examen;



import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import com.machmoum.examen.R;
import com.machmoum.examen.beans.Service;

public class ServiceList extends AppCompatActivity {
    RequestQueue requestQueue;
    private EditText nom;
    private Button submit;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_list);
        nom = findViewById(R.id.nom);
        submit = findViewById(R.id.add);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitFiliere();
            }
        });
    }
    public void submitFiliere() {
        String insertUrl = "http://192.168.230.67:8089/api/v1/services";
        JSONObject jsonBody = new JSONObject();
        try {
            JSONArray ServicesArray = new JSONArray();
            jsonBody.put("id", "");
            jsonBody.put("nom", nom.getText().toString());
            Log.d("student", jsonBody.toString());
            Toast.makeText(ServiceList.this, "Major Added", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ServiceList.this, MainActivity.class);
            ServiceList.this.finish();
            startActivity(intent);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST,
                insertUrl, jsonBody, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("resultat", response+"");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Erreur", error.toString());
            }
        });
        requestQueue.add(request);
    }

}