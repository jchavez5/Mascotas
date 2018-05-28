package com.josechavez.carros.view;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.josechavez.carros.R;

public class CrearCarro extends AppCompatActivity {
    private EditText txtPlaca,txtPrecio;
    private Spinner spn_marca,spn_modelo,spn_color;
    private String [] opc_marca,opc_modelo,opc_color;
    private ArrayAdapter<String> adp_marca,adp_modelo,adp_color;
    private Resources res = this.getResources();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_carro);

        txtPlaca = findViewById(R.id.txtPlaca);
        //Spinner de Marcas
        spn_marca = findViewById(R.id.lst_marca);
        opc_marca = res.getStringArray(R.array.op_marcas);
        adp_marca = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc_marca);
        //Spinner de Modelos
        spn_modelo = findViewById(R.id.lst_modelo);
        opc_modelo = res.getStringArray(R.array.op_modelos);
        adp_modelo = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc_modelo);
        //Spinner de Colores
        spn_color = findViewById(R.id.lst_color);
        opc_color = res.getStringArray(R.array.op_colores);
        adp_color = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc_color);

        txtPrecio = findViewById(R.id.txtPrecio);
        

    }
}
