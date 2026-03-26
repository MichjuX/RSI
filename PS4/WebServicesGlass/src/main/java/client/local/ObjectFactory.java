
package client.local;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client.local package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private static final QName _GetHelloWorldAsString_QNAME = new QName("http://paint.ms/", "getHelloWorldAsString");
    private static final QName _GetHelloWorldAsStringResponse_QNAME = new QName("http://paint.ms/", "getHelloWorldAsStringResponse");
    private static final QName _GetProducts_QNAME = new QName("http://paint.ms/", "getProducts");
    private static final QName _GetProductsResponse_QNAME = new QName("http://paint.ms/", "getProductsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client.local
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetHelloWorldAsString }
     * 
     * @return
     *     the new instance of {@link GetHelloWorldAsString }
     */
    public GetHelloWorldAsString createGetHelloWorldAsString() {
        return new GetHelloWorldAsString();
    }

    /**
     * Create an instance of {@link GetHelloWorldAsStringResponse }
     * 
     * @return
     *     the new instance of {@link GetHelloWorldAsStringResponse }
     */
    public GetHelloWorldAsStringResponse createGetHelloWorldAsStringResponse() {
        return new GetHelloWorldAsStringResponse();
    }

    /**
     * Create an instance of {@link GetProducts }
     * 
     * @return
     *     the new instance of {@link GetProducts }
     */
    public GetProducts createGetProducts() {
        return new GetProducts();
    }

    /**
     * Create an instance of {@link GetProductsResponse }
     * 
     * @return
     *     the new instance of {@link GetProductsResponse }
     */
    public GetProductsResponse createGetProductsResponse() {
        return new GetProductsResponse();
    }

    /**
     * Create an instance of {@link Product }
     * 
     * @return
     *     the new instance of {@link Product }
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHelloWorldAsString }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetHelloWorldAsString }{@code >}
     */
    @XmlElementDecl(namespace = "http://paint.ms/", name = "getHelloWorldAsString")
    public JAXBElement<GetHelloWorldAsString> createGetHelloWorldAsString(GetHelloWorldAsString value) {
        return new JAXBElement<>(_GetHelloWorldAsString_QNAME, GetHelloWorldAsString.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHelloWorldAsStringResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetHelloWorldAsStringResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://paint.ms/", name = "getHelloWorldAsStringResponse")
    public JAXBElement<GetHelloWorldAsStringResponse> createGetHelloWorldAsStringResponse(GetHelloWorldAsStringResponse value) {
        return new JAXBElement<>(_GetHelloWorldAsStringResponse_QNAME, GetHelloWorldAsStringResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProducts }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetProducts }{@code >}
     */
    @XmlElementDecl(namespace = "http://paint.ms/", name = "getProducts")
    public JAXBElement<GetProducts> createGetProducts(GetProducts value) {
        return new JAXBElement<>(_GetProducts_QNAME, GetProducts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetProductsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://paint.ms/", name = "getProductsResponse")
    public JAXBElement<GetProductsResponse> createGetProductsResponse(GetProductsResponse value) {
        return new JAXBElement<>(_GetProductsResponse_QNAME, GetProductsResponse.class, null, value);
    }

}
