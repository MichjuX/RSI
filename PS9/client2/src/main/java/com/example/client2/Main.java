package com.example.client2;

import com.example.client2.model.Message;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

public class Main {
    private static final String BASE_URI = "http://localhost:8080/messages";

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();

        System.out.println("\nGET /messages");
        WebTarget target = client.target(BASE_URI);
        List<Message> messages = target.request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Message>>() {});
        messages.forEach(System.out::println);

        System.out.println("\nGET /messages/1");
        WebTarget target1 = client.target(BASE_URI + "/1");
        Message msg1 = target1.request(MediaType.APPLICATION_JSON).get(Message.class);
        System.out.println("Original Message 1: " + msg1);

        System.out.println("\nPUT /messages");
        if (msg1 != null) {
            msg1.setMessage("Hello world!");
            Response putResponse = target1.request(MediaType.APPLICATION_JSON)
                    .put(Entity.entity(msg1, MediaType.APPLICATION_JSON));
            System.out.println("PUT status: " + putResponse.getStatus());
            Message updatedMsg1 = putResponse.readEntity(Message.class);
            System.out.println("Message 1: " + updatedMsg1);
        }

        // 2
        System.out.println("\nGET /messages?startsWith=He");
        WebTarget targetStartsWith = client.target(BASE_URI).queryParam("startsWith", "He");
        System.out.println("Requesting URI: " + targetStartsWith.getUri());
        List<Message> filteredMessages = targetStartsWith.request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Message>>() {});
        filteredMessages.forEach(System.out::println);

        System.out.println("\nGET ?startsWith=pi");
        WebTarget targetStartsWithPi = client.target(BASE_URI).queryParam("startsWith", "67");
        System.out.println("Requesting URI: " + targetStartsWithPi.getUri());
        List<Message> filteredMessagesPi = targetStartsWithPi.request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Message>>() {});
        filteredMessagesPi.forEach(System.out::println);

        client.close();
    }
}
