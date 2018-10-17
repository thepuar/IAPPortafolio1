
import app.Colas.Consumidor;
import app.Colas.Publisher;
import app.Transformador.JSONtoJSON;
import app.Transformador.XMLtoJSON;

public class Main {

    public static void main(String[] args) {

        //CONECTAR CON WEBSERVICE
        ConHTTP conTrafico = new ConHTTP(1); //Recibe JSON
        ConHTTP conBici = new ConHTTP(2); //Recibe XML
        String resultadoTrafico = conTrafico.conectar();
        String resultadoBici = conBici.conectar();

        //Publicar en cola RAW
        Publisher publicadorRAW = new Publisher("RAW");
        try {
            publicadorRAW.connect();
            publicadorRAW.send("parking.json", resultadoBici);
            publicadorRAW.send("trafico.xml",resultadoTrafico);
        } catch (Exception e) {
        }

        //Obtener de cola RAW
        Consumidor consumidorParking = new Consumidor("RAW", "parking.json");
        Consumidor consumidorTrafico = new Consumidor("RAW","trafico.xml");
        
        //TRANSFORMAR EN JSON
        JSONtoJSON json = new JSONtoJSON(resultadoTrafico);
        System.out.println(json.getJSON());
        System.out.println("");
        XMLtoJSON xml = new XMLtoJSON(resultadoBici);
        System.out.println(xml.getJSON());

        //PUBLICAR EN COLA JSON
        //CONSUMIR COLA JSON
    }

}
