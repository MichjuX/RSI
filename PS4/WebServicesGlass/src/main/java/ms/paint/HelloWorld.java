package ms.paint;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface HelloWorld {
    @WebMethod(
            operationName = "powitanie",      // Zmienia nazwę operacji w WSDL (zamiast getHelloWorldAsString)
            action = "urn:SayHelloAction"     // Dodaje nagłówek SOAPAction (widoczny w SoapUI)
    )
    String getHelloWorldAsString(String name);

    @WebMethod(
            operationName = "pobierzProdukty"  // Zmienia nazwę w XML na polską
    )
    java.util.List<Product> getProducts();
}


