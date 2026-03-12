package ms.paint;

import client.HelloWorldService;
import client.IHelloWorld;
import jakarta.xml.ws.Binding;
import jakarta.xml.ws.BindingProvider;

public class HelloWorldClient {
    public static void main(String[] args) {
        HelloWorldService service = new HelloWorldService();
        IHelloWorld hello = service.getHelloWorldPort();

        ((BindingProvider) hello).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
                "http://localhost:8081/ws/hello");

        String res = hello.getHelloWorldAsString("Michal");
        System.out.println("Res: " + res);
    }
}