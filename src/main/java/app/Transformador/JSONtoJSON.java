/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.Transformador;

import app.model.Trafico;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import org.dom4j.Node;
import org.json.JSONArray;
import org.json.JSONObject;
import app.model.*;

/**
 *
 * @author thepuar
 */
public class JSONtoJSON {

    enum ESTADO {
        FLUID, DENS, CONGESTIONAT, TALLAT,;
    }

    JSONObject job;
    List<String> lsjson;

    public JSONtoJSON(String cadena) {
        List<Trafico> listatrafico = new ArrayList<>();
        job = new JSONObject(cadena);
        JSONArray jarra = (JSONArray) job.get("features");
        Trafico calle;
        for (int i = 0; i < jarra.length(); i++) {
            calle = new Trafico();
            JSONObject jhijo = (JSONObject) jarra.get(i);
            JSONObject jproperties = (JSONObject) jhijo.get("properties");
            //Punto
            String punto = jproperties.get("denominacion").toString();
            calle.setPunto(punto);
            //Geometria
            JSONObject jgeometry = (JSONObject) jhijo.get("geometry");
            JSONArray coordenadas = jgeometry.getJSONArray("coordinates");
            String latitud = coordenadas.getJSONArray(0).get(0).toString();
            String longitud = coordenadas.getJSONArray(0).get(1).toString();
            calle.setLatitud(latitud);
            calle.setLongitud(longitud);
            //Estado
            String estado;
            try {
                estado = this.traEstado(Integer.parseInt((jproperties.get("estado").toString())));
            } catch (NumberFormatException nfe) {
                estado = "";
            }
            calle.setDescripcion(estado);
            
            listatrafico.add(calle);
            
            
        }
        JSONObject jcalle;
        lsjson = new ArrayList<>();
        for(Trafico lacalle: listatrafico){
            jcalle = new JSONObject();
            jcalle.put("punto", lacalle.getPunto());
            jcalle.put("tipo", lacalle.getTipo());
            jcalle.put("latitud", lacalle.getLatitud());
            jcalle.put("longitud", lacalle.getLongitud());
            jcalle.put("descripcion", lacalle.getDescripcion());
            lsjson.add(jcalle.toString());
        }
       
    }
    
    public List<String> getJson(){return this.lsjson;}

    public String traEstado(int value) {
        String cadena = "";
        switch (value) {
            case 0:
                cadena = "Fluid";
                break;
            case 1:
                cadena = "Dens";
                break;
            case 2:
                cadena = "Congestionat";
                break;
            case 3:
                cadena = "Tallat";
                break;
        }
        return cadena;
    }

}
