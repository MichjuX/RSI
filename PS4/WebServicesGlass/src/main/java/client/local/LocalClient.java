package client.local;

public class LocalClient {
    public static void main(String[] args) {
        HelloWorldImplService service = new HelloWorldImplService();
        HelloWorld port = service.getHelloWorldImplPort();

        // Wywołanie serwisu
        String response = port.getHelloWorldAsString("Student RSI");
        System.out.println("Odpowiedź serwisu: " + response);
    }
}