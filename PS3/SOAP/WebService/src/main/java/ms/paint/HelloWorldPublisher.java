package ms.paint;

import jakarta.xml.ws.Endpoint;

public class HelloWorldPublisher {
    public static void main(String[] args) {
        String url = "http://localhost:9999/ws/hello";
        Endpoint.publish(url, new HelloWorld());
        System.out.println("Published: " + url + "?wsdl");
    }
}