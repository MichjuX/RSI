package ms.paint.client;

import jakarta.xml.ws.BindingProvider;
import jakarta.xml.ws.handler.Handler;
import ms.paint.ws.ServerInfoService;
import ms.paint.ws.ServerInfo; // To jest interfejs wygenerowany (klient)
import java.util.List;

public class WsClient {
    public static void main(String[] args) {
        try {
            // 1. Inicjalizacja wygenerowanego serwisu
            ServerInfoService service = new ServerInfoService();
            // Używamy pełnej nazwy pakietu dla portu, aby uniknąć konfliktu z ms.paint.endpoint.ServerInfo
            ms.paint.ws.ServerInfo port = service.getServerInfoPort();

            // 2. Pobranie łańcucha handlerów i dodanie Twojego handlera MAC
            BindingProvider bp = (BindingProvider) port;
            List<Handler> handlerChain = bp.getBinding().getHandlerChain();
            handlerChain.add(new ms.paint.handler.MacAddressValidatorHandler());
            bp.getBinding().setHandlerChain(handlerChain);

            // 3. Wywołanie metody serwera
            System.out.println("--- KLIENT: Wywołuję metodę getServerName() ---");
            String response = port.getServerName();

            System.out.println("--- KLIENT: Odpowiedź serwera: " + response + " ---");

        } catch (Exception e) {
            System.err.println("Błąd klienta: " + e.getMessage());
            e.printStackTrace();
        }
    }
}