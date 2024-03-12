package com.example.apppokemon;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class AdaptadorDetallePokemon extends RecyclerView.Adapter<AdaptadorDetallePokemon.ViewHolderDetallePokemon> {



    List<PokeInfo>ListaImagenes;

    public AdaptadorDetallePokemon(List<PokeInfo> listaImagenes) {
        ListaImagenes = listaImagenes;
    }

    @NonNull
    @Override
    public AdaptadorDetallePokemon.ViewHolderDetallePokemon onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_foto_pokemon, parent, false);
        return new ViewHolderDetallePokemon(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorDetallePokemon.ViewHolderDetallePokemon holder, int position) {
        PokeInfo temporal =ListaImagenes.get(position);
        holder.cargarDatos(temporal);
    }

    @Override
    public int getItemCount() {
        return ListaImagenes.size();
    }

    public class ViewHolderDetallePokemon extends RecyclerView.ViewHolder {

        ImageView img_version_pokemon;
        public ViewHolderDetallePokemon(@NonNull View itemView) {
            super(itemView);
            this.img_version_pokemon=itemView.findViewById(R.id.id_foto_poke);
        }
        public void cargarDatos(PokeInfo fotoPokemon) {
            // Aquí deberías cargar la imagen utilizando una biblioteca como Picasso o Glide
            // Esto es solo un ejemplo, debes ajustarlo según tus necesidades
            Picasso.get().load(fotoPokemon.getUrl_imagen()).into(img_version_pokemon);
        }

    }


}
