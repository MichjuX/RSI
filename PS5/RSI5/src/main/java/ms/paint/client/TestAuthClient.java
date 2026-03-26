package ms.paint.client;

import jakarta.xml.ws.BindingProvider;
import jakarta.xml.ws.handler.MessageContext;
import ms.paint.ws.TestAuthService; // Wygenerowane przez wsimport
import ms.paint.ws.TestAuth;
import java.util.*;

public class TestAuthClient {
    public static void main(String[] args) {
        TestAuthService service = new TestAuthService();
        TestAuth port = service.getTestAuthPort();

        // Pobieramy RequestContext z portu [cite: 220]
        Map<String, Object> reqContext = ((BindingProvider) port).getRequestContext();

        // Tworzymy mapę nagłówków HTTP [cite: 220]
        Map<String, List<String>> headers = new HashMap<>();
        headers.put("Username", Collections.singletonList("jacek"));
        headers.put("Password", Collections.singletonList("123456"));

        // Wkładamy nagłówki do kontekstu pod odpowiednim kluczem [cite: 221]
        reqContext.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

        System.out.println("Wynik autentykacji: " + port.testUsername());
    }
}