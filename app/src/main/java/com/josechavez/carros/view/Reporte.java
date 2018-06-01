package com.josechavez.carros.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.josechavez.carros.Carro;
import com.josechavez.carros.Datos;
import com.josechavez.carros.Metodos;
import com.josechavez.carros.Principal;
import com.josechavez.carros.R;

import java.util.ArrayList;

public class Reporte extends AppCompatActivity {
    private ListView lvReporte;
    private String [] opc_Reporte;
    private Intent in_reporte;
    private static String db = "Carro";
    private DatabaseReference databaseReference;
    private ArrayList<Carro> carros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte);
        lvReporte=findViewById(R.id.lista_reporte);
        opc_Reporte = getResources().getStringArray(R.array.lista_reporte);
        ArrayAdapter<String> adpPrincipal = new ArrayAdapter(this,android.R.layout.simple_list_item_1,opc_Reporte);
        lvReporte.setAdapter(adpPrincipal);
        lvReporte.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                carros = new ArrayList<>();
                databaseReference = FirebaseDatabase.getInstance().getReference();
                databaseReference.child(db).addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        carros.clear();
                        if(dataSnapshot.exists()){
                            for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                                Carro c = snapshot.getValue(Carro.class);
                                carros.add(c);
                            }
                            System.out.println(carros.toString()+"--------------------------------------");
                        }
                        Datos.setCarros(carros);

                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {


                    }

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


                switch (i){
                    case 0:
                            numero(carros);
                        break;
                    case 1:
                        break;

                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                }
            }
        });

    }
    public void numero(ArrayList<Carro> carros){
        String cadena=Metodos.NCarros(carros)+"";
        Toast.makeText(this,cadena,Toast.LENGTH_LONG).show();
    }
}
