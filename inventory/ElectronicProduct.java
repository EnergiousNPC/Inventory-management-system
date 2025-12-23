package com.inventory;

public class ElectronicProduct extends Product {
    private int warrantyMonths;

    public ElectronicProduct(String id, String name, int quantity, double price, int warrantyMonths) {
        super(id, name, quantity, price);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public void displayInfo() {
        totalPrice = price * quantity;
        super.displayInfo();
        System.out.println("Warranty: " + warrantyMonths + " months");
    }
}
