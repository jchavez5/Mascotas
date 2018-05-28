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
import com.josechavez.carros.Carro;
import com.josechavez.carros.Datos;
import com.josechavez.carros.R;

import java.util.ArrayList;
public class ListaCarro extends AppCompatActivity implements AdaptadorCarro.OnCarroClickListener {
    private RecyclerView listaCarro;
    private static String db = "Carro";
    private DatabaseReference databaseReference;
    private Intent intent;
    private LinearLayoutManager llm;
    private AdaptadorCarro adapter;
    private ArrayList<Carro> carros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_carro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listaCarro=findViewById(R.id.listaCarro);
        carros = new ArrayList<>();

        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new AdaptadorCarro(carros,this);

        listaCarro.setLayoutManager(llm);
        listaCarro.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child(db).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                carros.clear();
                if(dataSnapshot.exists()){
                    for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                        Carro c = snapshot.getValue(Carro.class);
                        carros.add(c);
                    }
                }
                adapter.notifyDataSetChanged();
                Datos.setCarros(carros);
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

    @Override
    public void onCarroClick(Carro c) {

    }
}
