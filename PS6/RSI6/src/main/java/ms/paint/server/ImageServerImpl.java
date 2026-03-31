package ms.paint.server;

import jakarta.jws.WebService;
import jakarta.xml.ws.BindingType;
import jakarta.xml.ws.soap.MTOM;
import jakarta.xml.ws.soap.SOAPBinding;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

@MTOM(enabled = true, threshold = 1024)
@WebService(
        endpointInterface = "ms.paint.server.ImageServer",
        serviceName = "ImageServerImplService"
)
@BindingType(value = SOAPBinding.SOAP11HTTP_MTOM_BINDING)
public class ImageServerImpl implements ImageServer {

    @Override
    public Image downloadImage(String name) {
        try {
            File imageFile = new File("C:/rsi/" + name);
            return ImageIO.read(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String uploadImage(Image data) {
        if (data != null) {
            return "Upload Successful!";
        }
        return "Upload Failed.";
    }
}
