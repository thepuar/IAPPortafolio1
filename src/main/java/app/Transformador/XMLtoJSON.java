package app.Transformador;

import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;

public class XMLtoJSON {

    public XMLtoJSON(String cadena) {

        Document document;
        String sdireccion;
        try {
            document = DocumentHelper.parseText(cadena);

            List<Node> estaciones = document.selectNodes("//*[local-name() = 'Placemark']");
            for(Node elnodo : estaciones){
                Node ndireccion = elnodo.selectSingleNode(".//*[@name='address']");
                sdireccion = ndireccion.selectSingleNode(".//*[local-name()='value']").getText();
                System.out.println(sdireccion);
            }
           
            System.out.println("");
        } catch (DocumentException de) {
        }
    }

}
