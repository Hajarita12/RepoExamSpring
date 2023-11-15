/*package com.machmoum.examen;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.machmoum.examen.R;
import com.machmoum.examen.beans.Employe;
import com.machmoum.examen.beans.Service;

public class EmployeList extends AppCompatActivity {
    RequestQueue requestQueue;
    private List<Service> Services = new ArrayList<>();
    private Service selectedService;
    private EditText nom, prenom, photo, date;

    private Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employe_list);
        getServices();
        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        photo = findViewById(R.id.photo);
        date = findViewById(R.id.date);


        submit = findViewById(R.id.add);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitProfessor();
            }
        });
    }



    private void getServices() {
        String getFUrl = "http://192.168.1.191:8087/api/v1/Services";
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,
                getFUrl, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Gson gson = new Gson();
                Log.d("filieres",response.toString());
                TypeToken<List<Service>> token = new TypeToken<List<Service>>() {};
                Services = gson.fromJson(response.toString(), token.getType());

                // Créer un HashMap pour associer les noms des filières à leurs objets correspondants
                final HashMap<String, Service> ServiceMap = new HashMap<>();
                for (Service Service : Services) {
                    ServiceMap.put(Service.getNom(), Service);
                }


                List<String> nomServices = new ArrayList<>(ServiceMap.keySet());


                ArrayAdapter<String> adapter = new ArrayAdapter<>(EmployeList.this, android.R.layout.simple_spinner_item, nomServices);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                Spinner spinner = findViewById(R.id.spinner);
                spinner.setAdapter(adapter);

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                        String selectedServiceNom = (String) parentView.getItemAtPosition(position);


                        selectedService = ServiceMap.get(selectedServiceNom);


                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parentView) {

                    }
                });
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Erreur", error.toString());
            }
        });
        requestQueue.add(request);
    }






    public void submitProfessor() {
        String insertUrl = "http://192.168.1.191:8087/api/v1/Employes";
        JSONObject jsonBody = new JSONObject();
        try {






            jsonBody.put("id", "");
            jsonBody.put("nom", nom.getText().toString());
            jsonBody.put("prenom", prenom.getText().toString());
            jsonBody.put("photo", photo.getText().toString());
            jsonBody.put("date", date.getText().toString());

            JSONObject ServiceObject = new JSONObject();
            ServiceObject.put("id", selectedService.getId());
            ServiceObject.put("nom", selectedService.getNom());
            jsonBody.put("Service", ServiceObject);
            Log.d("student", jsonBody.toString());
            Toast.makeText(EmployeList.this, "Student Added", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(EmployeList.this, EmployeList.class);
            startActivity(intent);
            EmployeList.this.finish();
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

}*/
