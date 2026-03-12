package org.example;

import java.rmi.Naming;
import java.util.Scanner;

public class ChatClient {

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter Your name and press Enter:");
        String name = s.nextLine().trim();

        Chat client = new Chat(name);
        ChatInt server = (ChatInt) Naming.lookup("//localhost/ABC");

        server.send("[" + client.getName() + "] got connected");
        server.setClient(client);

        System.out.println("[System] Chat Remote Object is ready:");

        while (true) {
            String msg = s.nextLine().trim();
            server.send("[" + name + "] " + msg);
        }
    }
}