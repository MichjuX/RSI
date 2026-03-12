package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ProductInt extends Remote {
    List<Product> getProducts() throws RemoteException;
    Product findProductByName(String name) throws RemoteException;
}
