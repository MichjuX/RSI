package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();

    public ProductService() {
        products.add(new Product("Laptop 1", "aaa", 5000.0));
        products.add(new Product("Smartphone 1", "aaa", 3000.0));
        products.add(new Product("Smartphone 2", "aaa", 3000.0));
        products.add(new Product("Monitor 1", "bbb", 1500.0));
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    public List<Product> searchProducts(Product criteria) {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            boolean matches = true;
            if (criteria.getName() != null && !criteria.getName().isEmpty() &&
                    !p.getName().toLowerCase().contains(criteria.getName().toLowerCase())) {
                matches = false;
            }
            if (criteria.getProducer() != null && !criteria.getProducer().isEmpty() &&
                    !p.getProducer().toLowerCase().contains(criteria.getProducer().toLowerCase())) {
                matches = false;
            }
            if (criteria.getPrice() != null && p.getPrice() > criteria.getPrice()) {
                // If filter provides a price, let's treat it as max price
                matches = false;
            }

            if (matches) {
                result.add(p);
            }
        }
        return result;
    }
}
