package com.josechavez.carros.view;


import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.josechavez.carros.Carro;
import com.josechavez.carros.Datos;
import com.josechavez.carros.Persona;
import com.josechavez.carros.Principal;
import com.josechavez.carros.R;

public class CrearCarro extends AppCompatActivity {
    private EditText txtPlaca,txtPrecio,txtnombre;
    private Spinner spn_marca,spn_modelo,spn_color;
    private String [] opc_marca,opc_modelo,opc_color;
    private ArrayAdapter<String> adp_marca,adp_modelo,adp_color;
    private Bundle bundle;
    private Intent i;
    private String id_persona;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_carro);
        txtnombre=findViewById(R.id.txtnombre);
        txtPlaca = findViewById(R.id.txtPlaca);
        //Spinner de Marcas
        spn_marca = findViewById(R.id.lst_marca);
        opc_marca = this.getResources().getStringArray(R.array.op_marcas);
        adp_marca = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc_marca);
        spn_marca.setAdapter(adp_marca);
        //Spinner de Modelos
        spn_modelo = findViewById(R.id.lst_modelo);
        opc_modelo = this.getResources().getStringArray(R.array.op_modelos);
        adp_modelo = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc_modelo);
        spn_modelo.setAdapter(adp_modelo);
        //Spinner de Colores
        spn_color = findViewById(R.id.lst_color);
        opc_color = this.getResources().getStringArray(R.array.op_colores);
        adp_color = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc_color);
        spn_color.setAdapter(adp_color);
        txtPrecio = findViewById(R.id.txtPrecio);
        i =getIntent();
        bundle = i.getBundleExtra("datos");
        id_persona = bundle.getString("id");


    }
    public String obtenerCampo(Spinner spinner){
        String cadena="";
          cadena=spinner.getSelectedItem().toString();
            //Toast.makeText(this,cadena,Toast.LENGTH_LONG).show();
        return  cadena;
    }
    public int Numerofoto(Spinner spinner){
        int foto=0;
        int posicion=spinner.getSelectedItemPosition();
        if (posicion==0){
            foto=R.drawable.kia_logo_2560x1440;
        }
        if (posicion==1){
            foto=R.drawable.mazda_logo_1997_1920x1080;
        }
        if (posicion==2){
            foto=R.drawable.chevrolet_logo;
        }
        if (posicion==3){
            foto=R.drawable.nissan_emblem_2003_2048x2048;
        }
        return foto;
    }
    public void guardar(View view){
        String placa,precio,id,nombre;
        String marca,modelo,color;
        int foto;
        placa=txtPlaca.getText().toString();
        precio=txtPrecio.getText().toString();
        marca=obtenerCampo(spn_marca);
        modelo=obtenerCampo(spn_modelo);
        color=obtenerCampo(spn_color);
        id= Datos.getId();
        foto=Numerofoto(spn_marca);

        nombre=txtnombre.getText().toString();



        Carro c=new Carro(id,placa,marca,modelo,color,precio,foto);
        c.guardar(id_persona);
        Snackbar.make(view, getResources().getString(R.string.guardado),Snackbar.LENGTH_SHORT).setAction("Action",null).show();
        limpiar();
    }

    public void limpiar(View v){
        limpiar();
    }

    public void limpiar(){
        txtPrecio.setText("");
        txtPlaca.setText("");
        spn_marca.setSelection(0);
        spn_modelo.setSelection(0);
        spn_color.setSelection(0);
    }
    public void onBackPressed(){
        finish();
        Intent i = new Intent(CrearCarro.this,Principal.class);
        startActivity(i);
    }
}
