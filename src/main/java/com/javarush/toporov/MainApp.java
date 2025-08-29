package com.javarush.toporov;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        FileHandler fh = new FileHandler();

        String path = null;
        String inputText = null;

        int choice = ui.getEncryptionMethodChoice();
        int shift = ui.getKey();
        int mode = ui.getWorkModeChoice();

        if (mode == 1) {
            path = ui.getFilePath();
            if (path != null) {
                inputText = fh.readStringFromFile(path);
            }
        } else {
            inputText = ui.getTextFromConsole();
        }

        if (inputText == null) {
            System.out.println("No input text was provided. Exiting.");
            return;
        }
        String result;
        if (choice == 1) {
            result = CaesarCipher.encrypt(inputText, shift);
        } else {
            result = CaesarCipher.decrypt(inputText, shift);
        }

        if (mode == 1) {
            fh.writeStringToFile(path, result);
        } else {
            ui.printResult(result);
        }
    }
}
