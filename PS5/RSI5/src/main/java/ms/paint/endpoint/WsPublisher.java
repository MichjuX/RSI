package ms.paint.endpoint;

import jakarta.xml.ws.Endpoint;

public class WsPublisher {
    public static void main(String[] args) {
        String url = "http://localhost:8888/ws/server";
        System.out.println("Serwer startuje na: " + url);
        // Publikacja endpointu
        Endpoint.publish(url, new ServerInfo());


        String authUrl = "http://localhost:8889/ws/auth";
        System.out.println("Serwis autentykacji startuje na: " + authUrl);
        jakarta.xml.ws.Endpoint.publish(authUrl, new TestAuth());


        String shopUrl = "http://localhost:8890/ws/shop";
        System.out.println("Serwis ShopInfo startuje na: " + shopUrl);
        jakarta.xml.ws.Endpoint.publish(shopUrl, new ShopInfo());
    }
}