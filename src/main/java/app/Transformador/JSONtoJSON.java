/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.Transformador;

import java.util.Iterator;
import java.util.List;
import org.dom4j.Node;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author thepuar
 */
public class JSONtoJSON {
    JSONObject job;
    public JSONtoJSON(String cadena){
        job = new JSONObject(cadena);
        for(int i= 0; i< job.length();i++){
            JSONObject jhijo = job.getJSONObject("features");
            System.out.println("");
        }
        System.out.println("");
//        JSONObject jfeatures = job.getJSONObject("features");
//        JSONObject jproperties = jfeatures.getJSONObject("properties");
//        JSONObject jgeometry = jfeatures.getJSONObject("geometry");
//        System.out.println("");
        
    }
    
}
