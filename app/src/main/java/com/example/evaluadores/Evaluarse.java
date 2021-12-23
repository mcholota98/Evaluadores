package com.example.evaluadores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
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

import java.util.ArrayList;

public class Evaluarse extends AppCompatActivity {
    private RecyclerView Recycler;
    private elementoevaluarse Elemento;
    private ArrayList<elementoevaluarse> lista;
    Adaptere adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evaluarse);
        Bundle bundle = this.getIntent().getExtras();

        Recycler=findViewById(R.id.Recycler_evaluar);
        lista= new ArrayList<>();
        parseJson(bundle.getString("id"));
    }
    private void parseJson(String cedula){
        RequestQueue Requestq= Volley.newRequestQueue(this);
        String URL="https://uealecpeterson.net/ws/listadoaevaluar.php?e="+cedula;
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray tamaño = response.getJSONArray("listaaevaluar");
                    for(int i=0; i<tamaño.length(); i++) {
                        JSONObject jsonObject = new JSONObject(tamaño.get(i).toString());
                        elementoevaluarse listado = new elementoevaluarse(jsonObject.getString("id"),
                                jsonObject.getString("idevaluado"), jsonObject.getString("Nombres"),
                                jsonObject.getString("genero"), jsonObject.getString("situacion"),
                                jsonObject.getString("cargo"), jsonObject.getString("fechainicio"),
                                jsonObject.getString("imgJPG"));
                        lista.add(listado);
                    }
                }catch(JSONException jex) {
                    jex.printStackTrace();
                }
                Recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter =new Adaptere(getApplicationContext(),lista);
                Recycler.setAdapter(adapter);
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Requestq.add(request);
    }
}