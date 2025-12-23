package com.inventory;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Product> products;

    public Inventory() {
        products = new ArrayList<>();
    }

    public void addProduct(Product p) {
        products.add(p);
        System.out.println("Product added successfully.");
    }

    public void removeProduct(String id) {
        products.removeIf(p -> p.getId().equals(id));
        System.out.println("Product removed if it existed.");
    }

    public void displayAllProducts() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        for (Product p : products) {
            p.displayInfo();
            System.out.println("----------------------");
        }
    }
}
