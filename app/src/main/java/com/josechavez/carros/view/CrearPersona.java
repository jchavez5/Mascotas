package com.josechavez.carros.view;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.josechavez.carros.Carro;
import com.josechavez.carros.Datos;
import com.josechavez.carros.DatosPersonas;
import com.josechavez.carros.Persona;
import com.josechavez.carros.R;

import java.util.ArrayList;

public class CrearPersona extends AppCompatActivity {
    private EditText txtNombre,txtApellido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_persona);
        txtNombre=findViewById(R.id.txtnombre);
        txtApellido=findViewById(R.id.txtapellido);

    }
    public void guardar(View view){
        String nombre,apellido,id;
        nombre=txtNombre.getText().toString();
        apellido=txtApellido.getText().toString();
        id= DatosPersonas.getId();


        Persona p=new Persona(id,nombre,apellido, null
        );
        p.guardar();
        Snackbar.make(view, getResources().getString(R.string.guardado),Snackbar.LENGTH_SHORT).setAction("Action",null).show();
        limpiar();
    }

    public void limpiar(View v){
        limpiar();
    }

    public void limpiar(){
        txtApellido.setText("");
        txtNombre.setText("");

    }
}
