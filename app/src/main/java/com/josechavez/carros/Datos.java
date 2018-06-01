package com.josechavez.carros;

import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

/**
 * Created by Josechavez on 28/05/2018.
 */

public class Datos {
        private static ArrayList<Carro> carro = new ArrayList();
        private static String db = "Persona";
        private static DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        private static Persona p;

        public static void guardarPersona(String cadena,Carro c){
            //Persona p=null;
            // databaseReference.child(db).child(p.getId()).setValue(c);
           // databaseReference.child(db).child(cadena).setValue(p.getCarros().add(c));
           // databaseReference.child(db).child(cadena).setValue(c);
            databaseReference.child(db).child(cadena).child("carro").setValue(c);

        }


        public static ArrayList<Carro>obtener(){
            return carro;
        }

        public static String getId(){
            return databaseReference.push().getKey();
        }

        public static void setCarros(ArrayList<Carro> carros){
            Datos.carro= carros;

        }


}
