package com.example.evaluadores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {
    private RecyclerView Recycler;
    private elementovista Elemento;
    private ArrayList<elementovista> lista;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Recycler=findViewById(R.id.Recycler_vista);

        lista= new ArrayList<>();
        parseJson();
    }
    private void parseJson(){
        RequestQueue Requestq=Volley.newRequestQueue(this);
        String URL="https://www.uealecpeterson.net/ws/listadoevaluadores.php";
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray tamaño = response.getJSONArray("listaaevaluador");
                    for(int i=0; i<tamaño.length(); i++) {
                        JSONObject jsonObject = new JSONObject(tamaño.get(i).toString());
                        elementovista listado = new elementovista(jsonObject.getString("imgJPG"),
                                jsonObject.getString("imgjpg"), jsonObject.getString("idevaluador"),
                                jsonObject.getString("nombres"), jsonObject.getString("area"));
                        lista.add(listado);
                        }
                     }catch(JSONException jex) {
                    jex.printStackTrace();
                }
                Recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter =new Adapter(getApplicationContext(),lista);
                adapter =new Adapter(getApplicationContext(),lista);
                adapter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, Evaluarse.class);
                        Bundle b = new Bundle();
                        b.putString("id",lista.get(Recycler.getChildAdapterPosition(v)).getIdevaluador());
                        intent.putExtras(b);
                        startActivity(intent);
                    }
                });
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