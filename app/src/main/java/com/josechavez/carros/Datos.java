package com.josechavez.carros;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by Josechavez on 28/05/2018.
 */

public class Datos {
    private static ArrayList<Carro> carro = new ArrayList();
    private static String db = "Carro";
    private static DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    public static void guardar(Carro c){
        databaseReference.child(db).child(c.getId()).setValue(c);

    }

    public static ArrayList<Carro>obtener(){
        return carro;
    }

    public static String getId(){
        return databaseReference.push().getKey();
    }

    public static void setPersonas(ArrayList<Carro> carros){
        Datos.carro= carros;

    }
}
