package ms.paint;

import jakarta.jws.WebService;

@WebService(
        endpointInterface = "ms.paint.HelloWorld",
        serviceName = "MojaUsluga",
        portName = "MojPort"
)
public class HelloWorldImpl implements HelloWorld {
    @Override
    public String getHelloWorldAsString(String name) {
        return "Witaj świecie JAX-WS na WildFly: " + name; // [cite: 93]
    }

    @Override
    public java.util.List<Product> getProducts() {
        java.util.List<Product> produkty = new java.util.ArrayList<>();
        produkty.add(new Product("Laptop", "Sprzęt do RSI", 3500));
        produkty.add(new Product("Myszka", "Optyczna", 120));
        return produkty;
    }
}