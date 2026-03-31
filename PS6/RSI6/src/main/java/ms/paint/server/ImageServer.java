package ms.paint.server;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.awt.Image;

@WebService
public interface ImageServer {
    @WebMethod
    Image downloadImage(String name);

    @WebMethod
    String uploadImage(Image data);
}
