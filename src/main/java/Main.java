
import app.Transformador.JSONtoJSON;
import app.Transformador.XMLtoJSON;

public class Main {
    
    public static void main(String []args){
    
            ConHTTP conTrafico = new ConHTTP(1); //Recibe JSON
            ConHTTP conBici = new ConHTTP(2); //Recibe XML
            String resultadoTrafico = conTrafico.conectar();
            String resultadoBici = conBici.conectar();
            JSONtoJSON json = new JSONtoJSON(resultadoTrafico);
            XMLtoJSON xml = new XMLtoJSON(resultadoBici);
    }
    
}
