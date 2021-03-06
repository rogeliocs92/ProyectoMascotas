package com.example.miscontactosintens;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{

    ArrayList<Mascotas> mascotas;
    Activity activity;
    public ContactoAdaptador(ArrayList<Mascotas> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity=activity;
    }
    //inflar el layout y lo pasara  al viewholder para que obtenga los viewa
    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas,parent,false);
        return new ContactoViewHolder(v);
    }
    // asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder contactoViewHolder, int position) {
        Mascotas mascotas = this.mascotas.get(position);
        contactoViewHolder.imgFoto.setImageResource(mascotas.getFoto());
        contactoViewHolder.textNombre.setText(mascotas.getNombre());
        contactoViewHolder.textLikes.setText(mascotas.getLinkes());
        contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity,"Das Like a "+ mascotas.getNombre(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() { //cantidad de elementos que contiene mi lista
        return mascotas.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFoto;
        private TextView textNombre;
        private TextView textLikes;
        private ImageButton btnLike;
        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto     = itemView.findViewById(R.id.imgFoto);
            textNombre  = itemView.findViewById(R.id.textNombre);
            textLikes = itemView.findViewById(R.id.textLikes);
            btnLike= itemView.findViewById(R.id.btnLike);

        }
    }
}
