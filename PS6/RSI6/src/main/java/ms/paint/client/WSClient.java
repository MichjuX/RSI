package ms.paint.client;

import jakarta.xml.ws.Service;
import jakarta.xml.ws.soap.MTOMFeature;
import ms.paint.server.ImageServer;
import javax.xml.namespace.QName;
import java.net.URL;
import java.awt.Image;

public class WSClient {
    public static void main(String[] args) throws Exception {
        // SSL
        System.setProperty("javax.net.debug", "all");

        System.setProperty("javax.net.ssl.trustStore",
                "C:\\Users\\mks20\\Desktop\\Studia\\RSI\\wildfly-39.0.1.Final\\wildfly-39.0.1.Final\\standalone\\configuration\\application.keystore");
        System.setProperty("javax.net.ssl.trustStorePassword", "password");



        URL url = new URL("https://localhost:8443/RSI5/ImageServerImplService?wsdl");
        QName qname = new QName("http://server.paint.ms/", "ImageServerImplService");

        Service service = Service.create(url, qname);

        // MTOM
        MTOMFeature mtom = new MTOMFeature();
        ImageServer port = service.getPort(ImageServer.class, mtom);


        System.out.println("Pobieranie obrazu aaa.jpg...");
        Image img = port.downloadImage("aaa.jpg");

        if (img != null) {
            System.out.println("Obraz pobrany pomyślnie!");

            System.out.println("Wysyłanie obrazu z powrotem na serwer...");
            String response = port.uploadImage(img);

            System.out.println("Odpowiedź serwera: " + response);
        } else {
            System.out.println("Nie udało się pobrać obrazu.");
        }
    }
}