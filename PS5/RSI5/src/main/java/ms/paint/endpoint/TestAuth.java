package ms.paint.endpoint;

import jakarta.annotation.Resource;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.xml.ws.WebServiceContext;
import jakarta.xml.ws.handler.MessageContext;
import java.util.List;
import java.util.Map;

@WebService
public class TestAuth {

    @Resource
    private WebServiceContext wsContext; // Kontekst pozwalający dobrać się do nagłówków HTTP [cite: 105]

    @WebMethod
    public String testUsername() {
        // Pobieramy MessageContext z wstrzykniętego zasobu [cite: 118, 119]
        MessageContext mctx = wsContext.getMessageContext();

        // Pobieramy mapę nagłówków HTTP żądania [cite: 128, 129]
        Map<String, List<String>> httpHeaders = (Map<String, List<String>>)
                mctx.get(MessageContext.HTTP_REQUEST_HEADERS);

        // Wyciągamy listy dla kluczy "Username" i "Password" [cite: 132, 133, 136, 137]
        List<String> userList = httpHeaders.get("Username");
        List<String> passList = httpHeaders.get("Password");

        String username = (userList != null && !userList.isEmpty()) ? userList.get(0) : "";
        String password = (passList != null && !passList.isEmpty()) ? passList.get(0) : "";

        // Prosta weryfikacja loginu i hasła [cite: 244, 258]
        if ("jacek".equals(username) && "123456".equals(password)) {
            return "Użytkownik poprawny: " + username;
        } else {
            return "Błąd autoryzacji dla użytkownika: " + username;
        }
    }
}