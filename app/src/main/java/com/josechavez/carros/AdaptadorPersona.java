package com.josechavez.carros;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Josechavez on 01/06/2018.
 */

public class AdaptadorPersona extends RecyclerView.Adapter<AdaptadorPersona.PersonaViewHolder>{
    private ArrayList<Persona > personas;
    private AdaptadorPersona.OnPersonaClickListener clickListener;

    public AdaptadorPersona(ArrayList<Persona> personas, AdaptadorPersona.OnPersonaClickListener clickListener) {
        this.personas = personas;
        this.clickListener = clickListener;
    }

    @Override
    public AdaptadorPersona.PersonaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_persona, parent, false);
        return new AdaptadorPersona.PersonaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdaptadorPersona.PersonaViewHolder holder, int position) {
        final Persona p = personas.get(position);
        holder.nombre.setText(p.getNombre());
        holder.apellido.setText(p.getApellido());
        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onPersonaClick(p);
            }
        });
    }

    @Override
    public int getItemCount() {
        return personas.size();
    }

    public static class PersonaViewHolder extends RecyclerView.ViewHolder{
        private TextView  nombre;
        private TextView apellido;
        private View v;

        public PersonaViewHolder(View itemView){
            super(itemView);
            v = itemView;
            nombre = v.findViewById(R.id.lblNombre);
            apellido=v.findViewById(R.id.lblApellido);

        }

    }

    public interface OnPersonaClickListener{
        void onPersonaClick(Persona p);
    }

}
