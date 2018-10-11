package app.Transformador;

import app.model.EstacionVB;
import java.util.ArrayList;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;

public class XMLtoJSON {

    public XMLtoJSON(String cadena) {

        Document document;
        String spunto,scoordenadas,sbicis,svacio,slatitud,slongitud;
        try {
            document = DocumentHelper.parseText(cadena);

            List<Node> estaciones = document.selectNodes("//*[local-name() = 'Placemark']");
            List<EstacionVB> lestaciones = new ArrayList<>();
            EstacionVB estacion;
            for(Node elnodo : estaciones){
                estacion = new EstacionVB();
                //Dirección - punto
                Node ndireccion = elnodo.selectSingleNode(".//*[@name='address']");
                spunto = ndireccion.selectSingleNode(".//*[local-name()='value']").getText();
                estacion.setPunto(spunto);
                //Latitud y longitud
                scoordenadas = elnodo.selectSingleNode(".//*[local-name()='coordinates']").getText();
                estacion.setCoordenadas(scoordenadas);
                //Disponibles
                Node available = elnodo.selectSingleNode(".//*[@name='available']");
                sbicis = available.selectSingleNode(".//*[local-name()='value']").getText();
                estacion.setNumBicis(sbicis);
                //Vacias
                Node empty = elnodo.selectSingleNode(".//*[@name='free']");
                svacio = empty.selectSingleNode(".//*[local-name()='value']").getText();
                estacion.setNumvacios(svacio);
                lestaciones.add(estacion);
            }
            for(EstacionVB laestacion  : lestaciones){
                System.out.println(laestacion);
            }
            
           
            System.out.println("");
        } catch (DocumentException de) {
        }
    }

}
