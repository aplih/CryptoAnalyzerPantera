package com.javarush.toporov;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an encryption, method: \n 1. Encrypt \n 2. Decrypt");
        int choice = Integer.parseInt(scanner.nextLine());

        System.out.println("Choose key:");
        int shift = Integer.parseInt(scanner.nextLine());

        System.out.println("Do you want to work with a file or a console? \n 1. File \n 2.Console");
        int mode = Integer.parseInt(scanner.nextLine());

        String inputText;
        if (mode == 1) {
            System.out.println("Enter the path to the file:");
            String path = scanner.nextLine();
            inputText = Files.readString(Path.of(path), StandardCharsets.UTF_8);
        } else {
            System.out.println("Enter the text:");
            inputText = scanner.nextLine();
        }
        String result;
        if (choice == 1) {
            result = CaesarCipher.encrypt(inputText, shift);
        } else {
            result = CaesarCipher.decrypt(inputText, shift);
        }
        if (mode == 1) {
            Files.writeString(Path.of("output.txt"), result, StandardCharsets.UTF_8);
            System.out.println("The result is saved in output.txt");
        } else {
            System.out.println("The result: " + result);
        }

    }
}
