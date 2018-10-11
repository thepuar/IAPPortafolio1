
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author thepuar
 */
public class ConHTTP {

    String laurl1 = "http://mapas.valencia.es/lanzadera/opendata/Tra-estado-trafico/JSON";
    String laurl2 = "http://mapas.valencia.es/lanzadera/opendata/Valenbisi/KML";
    String laurl;
    HttpURLConnection con;

    public ConHTTP(int opcion) {
        if (opcion == 1) {
            this.laurl = this.laurl1;
        } else {
            this.laurl = this.laurl2;
        }
        try {
            URL url = new URL(laurl);
            con = (HttpURLConnection) url.openConnection();
        } catch (MalformedURLException mue) {
            System.out.println("URL INCORRECTA");
        } catch (IOException ioe) {
            System.out.println("IOEX");
        }
    }

    public String conectar() {
        try {
            con.setRequestMethod("GET");
        } catch (ProtocolException pe) {
            System.out.println("ProtocolException");
        }

        //Procesando la respuesta
        String inputLine;
        StringBuffer response = new StringBuffer();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
        } catch (IOException ioe) {
            System.out.println("IOE Procesando respuesta");
        }

        return response.toString();
    }
}
