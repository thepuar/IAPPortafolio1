
import app.Transformador.JSONtoJSON;


public class Main {
    
    public static void main(String []args){
    
            ConHTTP conTrafico = new ConHTTP(1); //Recibe JSON
            ConHTTP conBici = new ConHTTP(2); //Recibe XML
            String resultado = conTrafico.conectar();
            JSONtoJSON json = new JSONtoJSON(resultado);
    }
    
}
