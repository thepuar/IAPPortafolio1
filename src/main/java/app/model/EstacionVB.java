/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

/**
 *
 * @author thepu
 */
public class EstacionVB {
    String punto, tipo, latitud, longitud, descripcion, numbicis, numvacios, coordenadas;
    
    public EstacionVB(){
        this.tipo = "Estaciones ValenBisi";
    }

    public String getPunto() {
        return punto;
    }

    public void setPunto(String punto) {
        this.punto = punto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getDescripcion() {
        this.setDescripcion(descripcion);
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = "La estación tiene "+this.getNumBicis()+" disponibles y "+this.getNumvacios();
    }

    public String getNumBicis() {
        return numbicis;
    }

    public void setNumBicis(String numbicis) {
        this.numbicis = numbicis;
    }

    public String getNumvacios() {
        return numvacios;
    }

    public void setNumvacios(String numvacios) {
        this.numvacios = numvacios;
    }
    
    public void setCoordenadas(String coor){
        int poscoma = coor.indexOf(",");
        this.setLatitud(coor.substring(0, poscoma).trim());
        this.setLongitud(coor.substring(poscoma+1).trim());
    }
    
    public String toString(){
        return "Punto: "+this.getPunto()+" Tipo: "+this.getTipo()+" Latitud: "+this.getLatitud()+" Longitud: "+this.getLongitud()+" Descripcion: "+this.getDescripcion();
    }
    
    
}
