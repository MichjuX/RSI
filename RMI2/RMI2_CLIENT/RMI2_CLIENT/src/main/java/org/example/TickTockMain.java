package org.example;

import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

public class TickTockMain {
    public static void main(String[] args) {

        try{
            ProductInt myRemoteObject = (ProductInt) Naming.lookup("//172.20.10.8/ABC");


            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter the name of the product: ");
            String name = sc.nextLine();
            Product p = myRemoteObject.findProductByName(name);
            if(p == null){
                System.out.println("Product not found");
            }else{
                System.out.println("z" + p.getName() + " price: " + p.getPrice());
                p.setName("test");
                System.out.println("Product name: " + p.getName() + " price: " + p.getPrice());
            }

            List<Product> products = myRemoteObject.getProducts();
            for (Product product : products) {
                System.out.println(product);
            }

        }catch ( Exception e){
            e.printStackTrace();
        }

    }
}
