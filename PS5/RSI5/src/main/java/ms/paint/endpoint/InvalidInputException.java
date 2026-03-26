package ms.paint.endpoint;

import jakarta.xml.ws.WebFault;

@WebFault(name = "InvalidInputException") // [cite: 270]
public class InvalidInputException extends Exception {
    private String errorDetails; // [cite: 319]

    public InvalidInputException(String reason, String errorDetails) {
        super(reason); // [cite: 321]
        this.errorDetails = errorDetails; // [cite: 322]
    }

    // Metoda wymagana, aby JAX-WS mógł wyciągnąć detale do XML [cite: 337]
    public String getFaultInfo() {
        return errorDetails; // [cite: 338]
    }
}