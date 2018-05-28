package com.josechavez.carros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.josechavez.carros.view.CrearCarro;
import com.josechavez.carros.view.ListaCarro;
import com.josechavez.carros.view.Reporte;

public class Principal extends AppCompatActivity {
    private ListView lvPrincipal;
    private String [] opc_Principal;
    private Intent in_principal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        lvPrincipal = findViewById(R.id.lvPrincipal);
        opc_Principal = getResources().getStringArray(R.array.op_menu_principal);
        ArrayAdapter<String> adpPrincipal = new ArrayAdapter(this,android.R.layout.simple_list_item_1,opc_Principal);
        lvPrincipal.setAdapter(adpPrincipal);

        lvPrincipal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        in_principal= new Intent(Principal.this,CrearCarro.class);
                        startActivity(in_principal);
                        break;
                    case 1:
                        in_principal= new Intent(Principal.this,ListaCarro.class);
                        startActivity(in_principal);
                        break;

                    case 2:
                        in_principal= new Intent(Principal.this,Reporte.class);
                        startActivity(in_principal);
                        break;
                }
            }
        });
}
}
