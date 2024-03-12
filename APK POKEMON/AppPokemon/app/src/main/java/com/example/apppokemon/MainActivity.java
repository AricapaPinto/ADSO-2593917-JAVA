package com.example.apppokemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler;
    int pagina=0;
    String next,previous;

    Button btnAtras,btnSiguiente;

    List<Pokemon>ListaPokemones=new ArrayList<>();
    AdaptorPokemon adaptador=new AdaptorPokemon(ListaPokemones);
    ImageView gif_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // creamos una lista  de pokemones

        // aqui seleccionamos el recicler
        this.recycler=findViewById(R.id.recycler_pokemones);

         btnAtras = findViewById(R.id.btn_atras);
         btnSiguiente = findViewById(R.id.btn_siguiente);

         this.gif_image=findViewById(R.id.id_gif_img);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Incrementa la página y carga los nuevos datos
              pagina+=25;
                System.out.println("Siguiente:"+pagina);
                ConsumoPokemon();
            }
        });

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Decrementa la página solo si no es la primera página
                if (pagina > 1) {
                    pagina-=25;
                    System.out.println("Atras:"+pagina);
                    ConsumoPokemon();
                }
            }
        });
        ConsumoPokemon();
    }

    public void ConsumoPokemon(){

        Glide.with(getApplicationContext())
                .asGif()
                .load(R.drawable.loading_pokeball)
                .into(gif_image);

        this.gif_image.setVisibility(View.VISIBLE);
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

        String url = "https://pokeapi.co/api/v2/pokemon?offset=+"+this.pagina+"&limit=25";

        JsonObjectRequest solicitud =  new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println("El servidor responde OK");
                System.out.println("Pagina Actual :"+pagina);


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

            this.next=jsonPoke.getString("next");
            this.previous=jsonPoke.getString("previous");
            adaptador.LimpiarLista();
            JSONArray pokemones = jsonPoke.getJSONArray("results");

            // Ahora agregamos los datos al RecyclerView
            for (int i = 0; i < pokemones.length(); i++) {
                JSONObject pokemonData = pokemones.getJSONObject(i);
                String name = pokemonData.getString("name");
                String url = pokemonData.getString("url");
                String numPokemon =(pagina + i + 1 < 10 ? "000" : (pagina + i + 1 < 100 ? "00" : "")) + String.valueOf(pagina + i + 1);

                // Aquí puedes usar el nombre y la URL como desees
                // Por ejemplo, puedes agregarlos a tu lista de Pokémon
                ListaPokemones.add(new Pokemon(numPokemon,
                        name,
                        url
                ));
            }


            //(i + 1 < 10 ? "000" : (i + 1 < 100 ? "00" : "")) + String.valueOf(i + 1)
            gif_image.setVisibility(View.GONE);
            adaptador=new AdaptorPokemon(ListaPokemones);
            recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            recycler.setAdapter(adaptador);

            validarBtn();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

    }


    public void validarBtn(){

        if(this.next.equalsIgnoreCase("null")){
            this.btnSiguiente.setEnabled(false);

        }else{
            // habilitar
            this.btnSiguiente.setEnabled(true);
        }

        if(this.previous.equalsIgnoreCase("null")){
            // deshabilitar
            this.btnAtras.setEnabled(false);

        }else{
            // habilitar
            this.btnAtras.setEnabled(true);
        }

    }
}
