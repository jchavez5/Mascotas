package com.josechavez.carros.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.josechavez.carros.AdaptadorCarro;
import com.josechavez.carros.AdaptadorPersona;
import com.josechavez.carros.Carro;
import com.josechavez.carros.Datos;
import com.josechavez.carros.DatosPersonas;
import com.josechavez.carros.Persona;
import com.josechavez.carros.R;

import java.util.ArrayList;

public class ListaPersona extends AppCompatActivity implements AdaptadorPersona.OnPersonaClickListener{
    private RecyclerView listaPersona;
    private static String db = "Persona";
    private DatabaseReference databaseReference;
    private Intent intent;
    private LinearLayoutManager llm;
    private AdaptadorPersona adapter;
    private ArrayList<Persona> personas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_persona);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        listaPersona=findViewById(R.id.listaPersona);
        personas = new ArrayList<>();

        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        adapter=new AdaptadorPersona(personas,this);


        listaPersona.setLayoutManager(llm);
        listaPersona.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child(db).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                personas.clear();
                if(dataSnapshot.exists()){
                    for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                        Persona p = snapshot.getValue(Persona.class);
                        personas.add(p);
                    }
                }
                adapter.notifyDataSetChanged();
                DatosPersonas.setPersonas(personas);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

                FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    public void crearPersona(View v){
        intent = new Intent(ListaPersona.this,CrearPersona.class);
        startActivity(intent);
    }
    @Override
    public void onPersonaClick(Persona p) {
        Intent i = new Intent(ListaPersona.this,CrearCarro.class);
        Bundle b = new Bundle();
        b.putString("id",p.getId());


        i.putExtra("datos",b);
        startActivity(i);

    }
}
