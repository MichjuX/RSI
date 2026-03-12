package org.example;

import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

public class ProductClientMain {
    public static void main(String[] args) {

        try{
            ProductInt myRemoteObject = (ProductInt) Naming.lookup("//172.20.10.6/ABC");


            Scanner sc = new Scanner(System.in);
            IO.println("Please enter the name of the product: ");
            String name = sc.nextLine();
            Product p = myRemoteObject.findProductByName(name);
            if(p == null){
                IO.println("Product not found");
            }else{
                IO.println("Product name: " + p.getName() + " price: " + p.getPrice());
                p.setName("test");
                IO.println("Product name: " + p.getName() + " price: " + p.getPrice());
            }

            List<Product> products = myRemoteObject.getProducts();
            for (Product product : products) {
                IO.println(product);
            }

        }catch ( Exception e){
            e.printStackTrace();
        }

    }
}
