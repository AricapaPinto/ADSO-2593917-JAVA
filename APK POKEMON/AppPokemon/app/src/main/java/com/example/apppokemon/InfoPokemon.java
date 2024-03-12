package com.example.apppokemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

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
import java.util.List;

public class InfoPokemon extends AppCompatActivity {
    RecyclerView recycler;
    TextView nombre_po,id_altura,id_peso;
    List<PokeInfo>listaFotoPokemon=new ArrayList<>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_pokemon);

        recycler=findViewById(R.id.recycler_pokemon_info);
        this.nombre_po=findViewById(R.id.nombre_pokemon);
        this.id_altura=findViewById(R.id.id_altura);
        this.id_peso=findViewById(R.id.id_peso);
        // recuperamos los datos enviamos y se lo añadimos a nuestra vista
        Intent intent = getIntent();
        this.nombre_po.setText(intent.getStringExtra("pokemon_nombre"));
        // obtenemos la url para obtener la informacion que falta como las imagenes y demas

        String ulr=intent.getStringExtra("url");

        // verificamos que la url no venga vacia
        if(!ulr.equals("")){
            ConsumoInfoPoke(ulr);
        }
    }
    public void ConsumoInfoPoke(String url) {
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest solicitud = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println("El servidor responde OK");
                System.out.println(response.toString());
                // Procesar la respuesta y mostrar los datos
                mostrarDatosPokemon(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("El servidor responde con un error:");
                System.out.println(error.getMessage());
            }
        });

        queue.add(solicitud);
    }

    public void mostrarDatosPokemon(JSONObject response) {
        try {
            // Extraer datos específicos del JSON y realizar acciones necesarias
            int baseExperience = response.getInt("base_experience");
            String altura = response.getString("height");
            String peso = response.getString("weight");
            // mostramos el peso y la altura
            this.id_peso.setText(peso);
            this.id_altura.setText(altura);

            // Obtener el objeto "sprites"
            JSONObject spritesObject = response.getJSONObject("sprites");
            // Almacenar las URLs de las imágenes en una lista
            List<String> imageUrls = new ArrayList<>();
            imageUrls.add(spritesObject.getString("front_default"));
            imageUrls.add(spritesObject.getString("back_default"));
            imageUrls.add(spritesObject.getString("front_shiny"));
            imageUrls.add(spritesObject.getString("back_shiny"));

            // Obtener el objeto "other" dentro de "sprites"
            JSONObject otherObject = spritesObject.getJSONObject("other");

            // Obtener las URL de las imágenes dentro de "other"

            imageUrls.add(otherObject.getJSONObject("home").getString("front_default"));
            imageUrls.add(otherObject.getJSONObject("showdown").getString("front_default"));

            // ahora mostramos las imagenes de dicho pokemon
            for (int i=0;i<imageUrls.size();i++){
                String url_imagen = imageUrls.get(i);
                // aqui agregamos las imagenes pero usando el item que creamos para eso
                listaFotoPokemon.add(new PokeInfo(url_imagen));
            }
            // agregamos el adaptador
            LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
            recycler.setLayoutManager(layoutManager);
            AdaptadorDetallePokemon adaptador = new AdaptadorDetallePokemon(listaFotoPokemon);
            recycler.setAdapter(adaptador);

            JSONArray abilitiesArray = response.getJSONArray("abilities");
            // Obtén la referencia al LinearLayout en tu actividad o fragmento
            LinearLayout linearLayout = findViewById(R.id.linearHabilidades);
            // Itera a través de las habilidades
            for (int i = 0; i < abilitiesArray.length(); i++) {
                // Obtén el objeto de habilidad actual
                JSONObject abilityObject = abilitiesArray.getJSONObject(i);
                // Obtén el nombre de la habilidad
                String abilityName = abilityObject.getJSONObject("ability").getString("name");
                TextView textView = new TextView(getApplicationContext());
                textView.setTextSize(20);
                textView.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT // Cambiado a WRAP_CONTENT para el alto
                ));
                textView.setText(abilityName);
                // Agrega el TextView al LinearLayout
                linearLayout.addView(textView);

                // Agrega una línea separadora
                View separator = new View(getApplicationContext());
                separator.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        1 // Altura de la línea (puedes ajustar este valor)
                ));
                separator.setBackgroundColor(getResources().getColor(R.color.black));
                linearLayout.addView(separator);
            }
            // Aquí puedes llamar a otros métodos para mostrar los datos en tu aplicación
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}