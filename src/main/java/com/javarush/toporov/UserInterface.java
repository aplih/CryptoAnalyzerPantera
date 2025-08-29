package com.javarush.toporov;

import java.io.IOException;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);

    public int getEncryptionMethodChoice() {
        while (true) {
            System.out.println("Choose an encryption, method: \n 1. Encrypt \n 2. Decrypt");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1 || choice == 2) {
                    return choice;
                } else {
                    System.out.println("Please enter the correct value (1 or 2).");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public int getKey() {
        while (true) {
            System.out.println("Choose key:");
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public int getWorkModeChoice() {
        while (true) {
            System.out.println("Do you want to work with a file or a console? \n 1. File \n 2. Console");
            try {
                int mode = Integer.parseInt(scanner.nextLine());
                if (mode == 1 || mode == 2) {
                    return mode;
                } else {
                    System.out.println("Please enter the correct value (1 or 2).");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public String getFilePath() {
        while (true) {
            System.out.println("Enter the path to the file:");
            String path = scanner.nextLine();
            if (path != null && !path.trim().isEmpty()) {
                return path;
            } else {
                System.out.println("Please specify a valid file path.");
            }
        }
    }

    public String getTextFromConsole() {
        System.out.println("Enter the text:");
        return scanner.nextLine();
    }

    public void printResult(String result) {
        System.out.println("The result: " + result);
    }
}
