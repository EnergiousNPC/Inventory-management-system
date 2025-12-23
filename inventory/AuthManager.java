package com.inventory;

import java.util.Scanner;

public class AuthManager {
    private String username = "admin";
    private String password = "admin123";
    private final String petName = "snowy"; // security question answer

    public boolean login(Scanner scanner) {
        System.out.print("Username: ");
        String inputUser = scanner.nextLine();
        System.out.print("Password: ");
        String inputPass = scanner.nextLine();

        if (inputUser.equals(username) && inputPass.equals(password)) {
            System.out.println("Login successful.");
            return true;
        } else {
            System.out.println("Incorrect credentials.");
            return false;
        }
    }

    public void resetCredentials(Scanner scanner) {
        System.out.println("Reset Credentials");
        System.out.print("Enter your pet's name: ");
        String inputPet = scanner.nextLine();

        if (inputPet.equalsIgnoreCase(petName)) {
            System.out.print("Enter new username: ");
            username = scanner.nextLine();
            System.out.print("Enter new password: ");
            password = scanner.nextLine();
            System.out.println("Credentials updated successfully.");
        } else {
            System.out.println("Wrong pet name. Cannot reset.");
        }
    }
}
