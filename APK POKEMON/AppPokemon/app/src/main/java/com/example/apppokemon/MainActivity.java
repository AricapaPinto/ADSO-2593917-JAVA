package com.example.apppokemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler;
    int pagina=1;
    List<Pokemon>ListaPokemones=new ArrayList<>();
    AdaptorPokemon adaptador=new AdaptorPokemon(ListaPokemones);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // creamos una lista  de pokemones

        // aqui seleccionamos el recicler
        this.recycler=findViewById(R.id.recycler_pokemones);

        Button btnAtras = findViewById(R.id.btn_atras);
        Button btnSiguiente = findViewById(R.id.btn_siguiente);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Incrementa la página y carga los nuevos datos
                pagina++;
                System.out.println("Siguiente:"+pagina);
                ConsumoPokemon();
            }
        });

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Decrementa la página solo si no es la primera página
                if (pagina > 1) {
                    pagina--;
                    System.out.println("Atras:"+pagina);
                    ConsumoPokemon();
                }
            }
        });
        ConsumoPokemon();
    }

    public void ConsumoPokemon(){


        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

        String url = "https://pokeapi.co/api/v2/pokemon?offset=+"+pagina+"&limit=25";

        JsonObjectRequest solicitud =  new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println("El servidor responde OK");
                System.out.println(response.toString());
                // ahora cargamos los pokemones
                mostrarDatos((response));
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


    public void mostrarDatos(JSONObject jsonPoke){


        try {

            adaptador.LimpiarLista();
            JSONArray pokemones = jsonPoke.getJSONArray("results");

            // Ahora agregamos los datos al RecyclerView
            for (int i = 0; i < pokemones.length(); i++) {
                JSONObject pokemonData = pokemones.getJSONObject(i);
                String name = pokemonData.getString("name");
                String url = pokemonData.getString("url");

                // Aquí puedes usar el nombre y la URL como desees
                // Por ejemplo, puedes agregarlos a tu lista de Pokémon
                ListaPokemones.add(new Pokemon((i + 1 < 10 ? "000" : (i + 1 < 100 ? "00" : "")) + String.valueOf(i + 1),
                        name,
                        url
                ));
            }

            adaptador=new AdaptorPokemon(ListaPokemones);
            recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            recycler.setAdapter(adaptador);

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

    }



}