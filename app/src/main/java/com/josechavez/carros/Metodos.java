package com.josechavez.carros;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Josechavez on 28/05/2018.
 */

public class Metodos {
    private static DatabaseReference databaseReference;
    private static String db="Carro";

    public static DatabaseReference getDatabaseReference() {
        return databaseReference;
    }

    public static void setDatabaseReference(DatabaseReference databaseReference) {
        Metodos.databaseReference = databaseReference;
    }

    public static String getDb() {
        return db;
    }

    public static void setDb(String db) {
        Metodos.db = db;
    }

    public static  int NCarros(ArrayList<Carro> carro){
        int contador=0;
        for (int i = 0; i <carro.size() ; i++) {
            contador=contador+1;
        }
        return  contador;
    }
}
