package ms.paint;

import jakarta.jws.WebService;

@WebService(endpointInterface = "ms.paint.IHelloWorld")
public class HelloWorld implements IHelloWorld {
    @Override
    public String getHelloWorldAsString(String name) {
        return "Hello, World!" + name;
    }
}
