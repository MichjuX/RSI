package ms.paint.endpoint;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public class ShopInfo {

    @WebMethod
    public String getShopInfo(String name) throws InvalidInputException {
        if ("Jacek".equals(name)) {
            return "Akceptuję " + name; // Sukces [cite: 298, 299]
        } else {
            // Rzucenie wyjątku powoduje wygenerowanie błędu serwera (S:Server) [cite: 301, 355]
            throw new InvalidInputException("Nie właściwe dane wejściowe",
                    name + " - nazwa jest niewłaściwa.");
        }
    }
}