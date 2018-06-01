package com.josechavez.carros;

import android.support.annotation.ArrayRes;

import java.util.ArrayList;

/**
 * Created by Josechavez on 31/05/2018.
 */

public class Persona {
    private String id;
    private String nombre;
    private String apellido;
    private ArrayList<Carro> carros;

    public Persona(String id, String nombre, String apellido, ArrayList<Carro> carros) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.carros = carros;
    }

    public Persona() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public ArrayList<Carro> getCarros() {
        return carros;
    }

    public void setCarros(ArrayList<Carro> carros) {
        this.carros = carros;
    }
    public void guardar(){
        DatosPersonas.guardar(this);
    }

}
