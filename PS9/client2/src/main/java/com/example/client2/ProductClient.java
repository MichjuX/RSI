package com.example.client2;

import com.example.client2.model.Product;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

public class ProductClient {

    private static final String BASE_URI = "http://localhost:8080/products";

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target(BASE_URI);
        List<Product> products = target.request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Product>>() {});
        
        System.out.println("Wszystkie produkty:");
        products.forEach(System.out::println);

        Product searchCriteria = new Product();
        searchCriteria.setProducer("aaa");
        searchCriteria.setPrice(4000.0);

        System.out.println("\nKryteria wyszukiwania: " + searchCriteria);

        System.out.println();
        System.out.println("///\n");

        
        WebTarget searchTarget = client.target(BASE_URI + "/search");
        List<Product> filteredProducts = searchTarget.request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(searchCriteria, MediaType.APPLICATION_JSON), new GenericType<List<Product>>() {});
        
        System.out.println("Znalezione produkty:");
        filteredProducts.forEach(System.out::println);

        client.close();
    }
}
