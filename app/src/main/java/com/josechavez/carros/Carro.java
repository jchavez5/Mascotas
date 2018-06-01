package com.josechavez.carros;

/**
 * Created by Josechavez on 28/05/2018.
 */

public class    Carro {
    private String id;
    private String placa;
    private String marca;
    private String modelo;
    private String color;
    private String precio;
    private int foto;

    public Carro(String id, String placa, String marca, String modelo, String color, String precio,int foto) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
        this.foto=foto;
    }

    public Carro() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public void guardar(String cadena){
        Datos.guardarPersona(cadena,this);
    }
}
