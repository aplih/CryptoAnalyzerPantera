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

        // Если пользователь выбрал работу с файлом
        if (mode == 1) {
            // Получение пути к файлу от пользователя
            path = ui.getFilePath();
            // Проверка, что путь не пустой
            if (path != null) {
                // Чтение текста из файла с помощью FileHandler
                inputText = fh.readStringFromFile(path);
            }
        } else {
            // Получение текста напрямую из консоли
            inputText = ui.getTextFromConsole();
        }


        String result;
        // Если выбран режим шифрования
        if (choice == 1) {
            // Шифрование текста
            result = CaesarCipher.encrypt(inputText, shift);
        } else {
            result = CaesarCipher.decrypt(inputText, shift);
        }

        // Если результат нужно сохранить в файл
        if (mode == 1) {
            // Запись результата в файл
            fh.writeStringToFile(path, result);

        } else {
            // Вывод результата - консоль
            ui.printResult(result);
        }
    }
}
