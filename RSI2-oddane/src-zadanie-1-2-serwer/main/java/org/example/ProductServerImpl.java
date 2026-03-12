package org.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ProductServerImpl extends UnicastRemoteObject implements ProductInt {

    private List<Product> products;

    protected ProductServerImpl() throws RemoteException{
        super();
        products = new ArrayList<Product>();
        products.add(new Product("Czekolada", 8));
        products.add(new Product("Batonik", 4));
        products.add(new Product("Guma do zucia", 3));
    }

    @Override
    public List<Product> getProducts() throws RemoteException {
        IO.println("ProductServerImpl.getProducts()");
        return products;
    }

    @Override
    public Product findProductByName(String name) throws RemoteException {
        IO.println("ProductServerImpl.findProductByName() " + name);
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

}
