/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory;

import java.util.*;

class Product {
    protected String name;
    protected double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }

    public double getPrice() { return price; }

    public String toString() {
        return name + " - $" + price;
    }
}

// Inheritance examples
class Electronic extends Product {
    public Electronic(String name, double price) {
        super(name, price);
    }
}

class Book extends Product {
    public Book(String name, double price) {
        super(name, price);
    }
}

class Cart {
    private List<Product> items = new ArrayList<>();

    public void addProduct(Product p) {
        items.add(p);
        System.out.println(p.getName() + " added to cart.");
    }

    public void removeProduct(String name) {
        for (Product p : items) {
            if (p.getName().equalsIgnoreCase(name)) {
                items.remove(p);
                System.out.println(name + " removed from cart.");
                return;
            }
        }
        System.out.println(name + " not found in cart.");
    }

    public void viewCart() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        System.out.println("Your Cart:");
        double total = 0;
        for (Product p : items) {
            System.out.println("- " + p);
            total += p.getPrice();
        }
        System.out.println("Total: $" + total);
    }

    public void checkout() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty. Nothing to checkout.");
        } else {
            double total = 0;
            for (Product p : items) {
                total += p.getPrice();
            }
            System.out.println("Checkout complete. Total paid: $" + total);
            items.clear();
        }
    }
}

class User {
    private String username;
    private String password;
    private String securityQuestion;
    private String securityAnswer;

    public User(String username, String password, String securityQuestion, String securityAnswer) {
        this.username = username;
        this.password = password;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer.toLowerCase();
    }

    public boolean login(String uname, String pass) {
        return this.username.equals(uname) && this.password.equals(pass);
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public boolean checkSecurityAnswer(String answer) {
        return this.securityAnswer.equals(answer.toLowerCase());
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public String getUsername() {
        return username;
    }
}

public class ShoppingCart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a user with a security question
        User user = new User(
            "admin",
            "1234",
            "What is your favorite season?",
            "winter"
        );

        // Sample products
        List<Product> products = new ArrayList<>();
        products.add(new Electronic("Laptop", 1200.00));
        products.add(new Electronic("Phone", 800.00));
        products.add(new Electronic("Headphones", 150.00));
        products.add(new Book("Book", 20.00));

        Cart cart = new Cart();

        System.out.println("=== Welcome to the Online Shopping System ===");
        System.out.print("Do you want to (1) Login or (2) Reset Password? ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (choice == 2) {
            System.out.println("Security Check: " + user.getSecurityQuestion());
            System.out.print("Your Answer: ");
            String answer = scanner.nextLine();

            if (user.checkSecurityAnswer(answer)) {
                System.out.print("Enter new password: ");
                String newPass = scanner.nextLine();
                user.setPassword(newPass);
                System.out.println("Password reset successful! Please login now.");
            } else {
                System.out.println("Incorrect answer. Password reset failed.");
                return;
            }
        }

        // Login attempt
        System.out.println("=== Login ===");
        System.out.print("Username: ");
        String uname = scanner.nextLine();
        System.out.print("Password: ");
        String pass = scanner.nextLine();

        if (!user.login(uname, pass)) {
            System.out.println("Incorrect username or password.");
            System.out.print("Do you want to reset your password? (yes/no): ");
            String resetChoice = scanner.nextLine();

            if (resetChoice.equalsIgnoreCase("yes")) {
                System.out.println("Security Check: " + user.getSecurityQuestion());
                System.out.print("Your Answer: ");
                String answer = scanner.nextLine();

                if (user.checkSecurityAnswer(answer)) {
                    System.out.print("Enter new password: ");
                    String newPass = scanner.nextLine();
                    user.setPassword(newPass);
                    System.out.println("Password reset successful! Please login now.");

                    // Retry login
                    System.out.print("Username: ");
                    uname = scanner.nextLine();
                    System.out.print("Password: ");
                    pass = scanner.nextLine();

                    if (!user.login(uname, pass)) {
                        System.out.println("Login failed again. Exiting...");
                        return;
                    }

                } else {
                    System.out.println("Incorrect answer. Password reset failed.");
                    return;
                }
            } else {
                System.out.println("Login aborted. Exiting...");
                return;
            }
        }

        System.out.println("Login successful!");

        // Main shopping loop
        while (true) {
            System.out.println("\n=== Shopping Menu ===");
            System.out.println("1. View Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. Remove Product from Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Checkout");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int menu = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (menu) {
                case 1:
                    System.out.println("Available Products:");
                    for (int i = 0; i < products.size(); i++) {
                        System.out.println((i + 1) + ". " + products.get(i));
                    }
                    break;
                case 2:
                    System.out.print("Enter product name to add: ");
                    String addName = scanner.nextLine();
                    boolean foundAdd = false;
                    for (Product p : products) {
                        if (p.getName().equalsIgnoreCase(addName)) {
                            cart.addProduct(p);
                            foundAdd = true;
                            break;
                        }
                    }
                    if (!foundAdd) System.out.println("Product not found.");
                    break;
                case 3:
                    System.out.print("Enter product name to remove: ");
                    String removeName = scanner.nextLine();
                    cart.removeProduct(removeName);
                    break;
                case 4:
                    cart.viewCart();
                    break;
                case 5:
                    cart.checkout();
                    break;
                case 0:
                    System.out.println("Thank you for shopping with us!");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
