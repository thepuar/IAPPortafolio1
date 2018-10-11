package app.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thepu
 */
public class Trafico {
    String Punto;
    String Tipo;
    String Latitud;
    String Longitud;
    String Descripcion;
    
    public Trafico(){
        this.Tipo="Datos de tráfico";
    }
    

    public String getPunto() {
        return Punto;
    }

    public void setPunto(String Punto) {
        this.Punto = Punto;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getLatitud() {
        return Latitud;
    }

    public void setLatitud(String Latitud) {
        this.Latitud = Latitud;
    }

    public String getLongitud() {
        return Longitud;
    }

    public void setLongitud(String Longitud) {
        this.Longitud = Longitud;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = "El estado del tráfico es "+Descripcion;
    }
    
    
}
