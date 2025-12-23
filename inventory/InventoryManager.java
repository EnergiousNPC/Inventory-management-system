package com.inventory;

import java.util.Scanner;

public class InventoryManager {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        AuthManager auth = new AuthManager();
        Scanner scanner = new Scanner(System.in);

        boolean authenticated = false;

        while (!authenticated) {
            System.out.println("\n=== Welcome to Inventory System ===");
            System.out.println("1. Login");
            System.out.println("2. Forgot Password");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> authenticated = auth.login(scanner);
                case 2 -> auth.resetCredentials(scanner);
                default -> System.out.println("Invalid choice.");
            }
        }

        boolean running = true;

        while (running) {
            System.out.println("\n=== Inventory Menu ===");
            System.out.println("1. Add Electronic Product");
            System.out.println("2. Add Grocery Product");
            System.out.println("3. Remove Product");
            System.out.println("4. Show All Products");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Quantity: ");
                    int qty = scanner.nextInt();
                    System.out.print("Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Warranty (months): ");
                    int warranty = scanner.nextInt();
                    scanner.nextLine();

                    inventory.addProduct(new ElectronicProduct(id, name, qty, price, warranty));
                }
                case 2 -> {
                    System.out.print("ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Quantity: ");
                    int qty = scanner.nextInt();
                    System.out.print("Price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Expiry Date: ");
                    String expiry = scanner.nextLine();

                    inventory.addProduct(new GroceryProduct(id, name, qty, price, expiry));
                }
                case 3 -> {
                    System.out.print("Enter Product ID to remove: ");
                    String id = scanner.nextLine();
                    inventory.removeProduct(id);
                }
                case 4 -> inventory.displayAllProducts();
                case 0 -> running = false;
                default -> System.out.println("Invalid option!");
            }
        }

        scanner.close();
        System.out.println("Session ended.");
    }
}
