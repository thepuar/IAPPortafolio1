package app;

import app.Colas.Consumidor;
import app.Colas.Publisher;
import app.Transformador.JSONtoJSON;
import app.Transformador.XMLtoJSON;
import java.util.Scanner;

public class Main {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        switch (menu()) {
            case 1:
                opc1();
                break;
            case 2:
                opc2();
                break;
            case 3:
                opc3();
                break;
            case 4:
                opc4();

        }
    }

    //Todo junto
    public static void opc1() {
        //CONECTAR CON WEBSERVICE
        ConHTTP conTrafico = new ConHTTP(1); //Recibe JSON
        ConHTTP conBici = new ConHTTP(2); //Recibe XML
        String resultadoTrafico = conTrafico.conectar();
        String resultadoBici = conBici.conectar();

        //Obtener de cola RAW
        Consumidor consumidorParking = new Consumidor("RAW", "parking.xml", 1);
        Consumidor consumidorTrafico = new Consumidor("RAW", "trafico.json", 2);
        Consumidor consumidorLogger = new Consumidor("NOMINAL", "", 3);

        //Publicar en cola RAW
        Publisher publicadorRAW = new Publisher("RAW");
        try {
            publicadorRAW.connect();
            publicadorRAW.send("parking.xml", resultadoBici);
            publicadorRAW.send("trafico.json", resultadoTrafico);
        } catch (Exception e) {
        }
    }

    //Consume HTTP y manda a RAW (XML y JSON)
    public static void opc2() {
        //CONECTAR CON WEBSERVICE
        ConHTTP conTrafico = new ConHTTP(1); //Recibe JSON
        ConHTTP conBici = new ConHTTP(2); //Recibe XML
        String resultadoTrafico = conTrafico.conectar();
        String resultadoBici = conBici.conectar();
        Publisher publicadorRAW = new Publisher("RAW");
        try {
            publicadorRAW.connect();
            publicadorRAW.send("parking.xml", resultadoBici);
            publicadorRAW.send("trafico.json", resultadoTrafico);
        } catch (Exception e) {
        }
    }

    //Consumen de Raw, transforman y mandan a NOMINAL (JSON)
    public static void opc3() {
        Consumidor consumidorParking = new Consumidor("RAW", "parking.xml", 1);
        Consumidor consumidorTrafico = new Consumidor("RAW", "trafico.json", 2);
    }

    //Consume NOMINAL e imprime por pantalla
    public static void opc4() {
        Consumidor consumidorLogger = new Consumidor("NOMINAL", "", 3);
    }

    public static int menu() {
        System.out.println("####################");
        System.out.println("#      INICIO      #");
        System.out.println("####################");
        System.out.println("Opciones:");
        System.out.println("1.- Todos en un proceso");
        System.out.println("2.- Conectores");
        System.out.println("3.- Transformadores");
        System.out.println("4.- Logger");
        System.out.println("0.- Cerrar");
        int opc = teclado.nextInt();
        return opc;
    }

    public static String askIp() {
        System.out.print("Dime la dirección Ip del servidor Rabbit:");
        String valor = teclado.nextLine();
        System.out.println("");
        return valor;
    }

    public static void consumirEnColaParking(String cadena) {
        XMLtoJSON xml = new XMLtoJSON(cadena);
        Publisher publicador = new Publisher("NOMINAL");
        try {
            publicador.connect();
            publicador.send("", xml.getJSON());
        } catch (Exception e) {
        }
    }

    public static void consumirEnColaTrafico(String cadena) {
        JSONtoJSON json = new JSONtoJSON(cadena);
        Publisher publicador = new Publisher("NOMINAL");
        try {
            publicador.connect();
            publicador.send("", json.getJSON());
        } catch (Exception e) {
        }

    }

    public static void consumirEnColaNominal(String cadena) {
        System.out.println("Cola nominal: " + cadena);
    }

}
