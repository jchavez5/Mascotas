package com.josechavez.carros;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by Josechavez on 31/05/2018.
 */

public class DatosPersonas {
    private static ArrayList<Persona> personas = new ArrayList();
    private static String db = "Persona";
    private static DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    public static void guardar(Persona c){
        databaseReference.child(db).child(c.getId()).setValue(c);

    }

    public static ArrayList<Persona>obtener(){
        return personas;
    }

    public static String getId(){
        return databaseReference.push().getKey();
    }

    public static void setPersonas(ArrayList<Persona> personas){
        DatosPersonas.personas= personas;

    }
}
