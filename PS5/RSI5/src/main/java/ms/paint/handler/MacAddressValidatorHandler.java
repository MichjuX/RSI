package ms.paint.handler;

import javax.xml.namespace.QName;
import jakarta.xml.soap.*;
import jakarta.xml.ws.handler.MessageContext;
import jakarta.xml.ws.handler.soap.*;
import java.util.Collections;
import java.util.Set;

public class MacAddressValidatorHandler implements SOAPHandler<SOAPMessageContext> {

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        // Sprawdzenie czy wiadomość jest wychodząca (klient) czy przychodząca (serwer) [cite: 7]
        Boolean isOutbound = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        try {
            SOAPMessage msg = context.getMessage();
            SOAPEnvelope env = msg.getSOAPPart().getEnvelope();
            SOAPHeader header = env.getHeader() == null ? env.addHeader() : env.getHeader();

            if (isOutbound) {
                // LOGIKA KLIENTA: Wstrzykujemy adres MAC do nagłówka [cite: 8]
                Name qname = env.createName("MACAddress", "ns", "http://rsi.jg.org/");
                header.addChildElement(qname).addTextNode("A0-36-BC-2D-ED-61");
                System.out.println("Client: Wstrzyknięto MAC address."); //[cite: 77]
            } else {
                // LOGIKA SERWERA: Odczytujemy adres MAC z nagłówka [cite: 9]
                var nodes = header.getElementsByTagNameNS("http://rsi.jg.org/", "MACAddress");
                if (nodes.getLength() > 0) {
                    String mac = nodes.item(0).getChildNodes().item(0).getNodeValue();
                    System.out.println("Server: Odebrano MAC: " + mac); //[cite: 77]
                }
            }
        } catch (SOAPException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Set<QName> getHeaders() { return Collections.emptySet(); }
    @Override
    public boolean handleFault(SOAPMessageContext context) { return true; }
    @Override
    public void close(MessageContext context) {}
}