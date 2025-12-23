package com.inventory;

public class GroceryProduct extends Product {
    private String expiryDate;

    public GroceryProduct(String id, String name, int quantity, double price, String expiryDate) {
        super(id, name, quantity, price);
        this.expiryDate = expiryDate;
    }

    @Override
    public void displayInfo() {
        totalPrice = price * quantity;
        super.displayInfo();
        System.out.println("Expiry Date: " + expiryDate + " months");
    }
}
