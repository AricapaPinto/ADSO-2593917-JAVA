package com.example.apppokemon;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptorPokemon extends RecyclerView.Adapter<AdaptorPokemon.ViewHolderPokemon> {
    List<Pokemon>ListaPokemones;

    public AdaptorPokemon(List<Pokemon> listaPokemones) {
        ListaPokemones = listaPokemones;
    }

    @NonNull
    @Override
    public AdaptorPokemon.ViewHolderPokemon onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);
        return new ViewHolderPokemon(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptorPokemon.ViewHolderPokemon holder, int position) {
        Pokemon temporal=ListaPokemones.get(position);
        holder.cargarDatos(temporal);
    }

    @Override
    public int getItemCount() {
        return ListaPokemones.size() ;
    }


    public void LimpiarLista(){
        ListaPokemones.clear();

    }
    public class ViewHolderPokemon extends RecyclerView.ViewHolder {

        // creamos las los datos para llenar los pokemones desde aqui
        TextView identificador,id_nombre;
        Context contexto;
        ImageView imgInfo;
        // creamos los botones de siguiente y atras

        public ViewHolderPokemon(@NonNull View itemView) {
            super(itemView);
            contexto=itemView.getContext();
            this.identificador=itemView.findViewById(R.id.identificador);
            this.id_nombre=itemView.findViewById(R.id.id_nombre);
            this.imgInfo=itemView.findViewById(R.id.id_infoPoke);

        }

        // aqui creamos el metodo para cargar los datos

        public void cargarDatos(Pokemon informacion) {
            id_nombre.setText(informacion.getNombre());
            identificador.setText(informacion.getId());

            this.imgInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Manejar el clic en el ImageView aquí aquí se le manda la url del pokemon
                    Toast.makeText(contexto, informacion.getNombre(), Toast.LENGTH_LONG).show();

                    // Crear un Intent para abrir la nueva actividad
                    Intent intencion = new Intent(contexto,InfoPokemon.class);

                    // Puedes pasar datos adicionales al intent si es necesario
                    intencion.putExtra("pokemon_nombre", informacion.getNombre());
                    intencion.putExtra("url", informacion.getUrl());

                    // Iniciar la nueva actividad
                    contexto.startActivity(intencion);
                }
            });
        }

    }


}
