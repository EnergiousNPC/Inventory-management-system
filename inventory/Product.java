package com.inventory;

public class Product {
    protected String id;
    protected String name;
    protected int quantity;
    protected double price;
    protected double totalPrice;

    public Product(String id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + name + ", Quantity: " + quantity + ", Price: $" + price + " each" + " ,Total Price: $" + totalPrice);
    }

    public String getId() {
        return id;
    }
}
