package org.example;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ProductServerMain {
    public static void main(String[] args) {
        try{
            System.setProperty("java.rmi.server.codebase","file:/E:/RSI/RMI2_SERVER/target/classes");
            IO.println("Codebase: " + System.getProperty("java.rmi.server.codebase"));
            LocateRegistry.createRegistry(1099);
            ProductServerImpl obj1 = new ProductServerImpl();
            Naming.rebind("//172.20.10.8/ABC", obj1);
            IO.println("Serwer oczekuje ...");
        } catch (RuntimeException | RemoteException | MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
