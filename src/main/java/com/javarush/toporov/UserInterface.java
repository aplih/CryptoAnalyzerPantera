package com.javarush.toporov;

import java.io.IOException;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);

    // Метод для получения выбора шифрования/дешифрования.
    public int getEncryptionMethodChoice() {
        // Бесконечный цикл, который работает до получения верного ответа
        while (true) {
            System.out.println("Choose an encryption, method: \n 1. Encrypt \n 2. Decrypt");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1 || choice == 2) {
                    return choice;
                } else {
                    // если число некорректно
                    System.out.println("Please enter the correct value (1 or 2).");
                }
                // Ловим ошибку, если введено не число
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    // Метод для получения ключа (сдвига)
    public int getKey() {
        // Цикл для проверки корректности ввода ключа
        while (true) {
            System.out.println("Choose key:");
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    // Метод для получения выбора режима (файл/консоль)
    public int getWorkModeChoice() {
        // Цикл для проверки корректности ввода режима
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

    // Метод для получения пути к файлу
    public String getFilePath() {
        // Цикл для проверки, что путь не пустой
        while (true) {
            System.out.println("Enter the path to the file:");
            String path = scanner.nextLine();
        }
    }

    // Метод для получения текста из консоли
    public String getTextFromConsole() {
        System.out.println("Enter the text:");
        return scanner.nextLine();
    }

    // Метод для вывода результата в консоль
    public void printResult(String result) {
        System.out.println("The result: " + result);
    }
}
