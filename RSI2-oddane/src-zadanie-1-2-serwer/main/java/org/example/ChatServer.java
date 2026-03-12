package org.example;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

public class ChatServer {
    public static void main(String[] args) {
        try {
            System.setProperty("java.rmi.server.codebase", "file:/E:/RSI/RMI2_SERVER/target/classes");
            IO.println("Codebase: " + System.getProperty("java.rmi.server.codebase"));

            LocateRegistry.createRegistry(1099);
            Chat server = new Chat("Server");
            Naming.rebind("rmi://localhost/ABC", server);

            Scanner s = new Scanner(System.in);
            while (true) {
                String msg = s.nextLine().trim();
                if (server.getClient() != null) {
                    ChatInt client = server.getClient();
                    msg = "[" + server.getName() + "] " + msg;
                    client.send(msg);
                }
            }

        } catch (Exception ex) {
            IO.println("Server failed: " + ex);
        }
    }
}