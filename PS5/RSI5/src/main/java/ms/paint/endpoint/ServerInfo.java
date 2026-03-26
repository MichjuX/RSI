package ms.paint.endpoint;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.HandlerChain;

@WebService
@HandlerChain(file = "handler-chain.xml") // Powiązanie z handlerem
public class ServerInfo {

    @WebMethod
    public String getServerName() {
        return "Jaco server 1"; // Przykładowa odpowiedź serwera [cite: 81]
    }
}