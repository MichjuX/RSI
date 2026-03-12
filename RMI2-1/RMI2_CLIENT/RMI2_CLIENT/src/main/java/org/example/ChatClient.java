package org.example;

import java.rmi.Naming;
import java.util.Scanner;

public class ChatClient {

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);

        IO.println("Enter Your name and press Enter:");
        String name = s.nextLine().trim();

        Chat client = new Chat(name);
        ChatInt server = (ChatInt) Naming.lookup("//172.20.10.6/ABC");

        server.send("[" + client.getName() + "] got connected");
        server.setClient(client);

        IO.println("[System] Chat Remote Object is ready:");

        while (true) {
            String msg = s.nextLine().trim();
            server.send("[" + name + "] " + msg);
        }
    }
}