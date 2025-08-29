package com.javarush.toporov;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandler {

    // Метод для чтения содержимого файла
    public String readStringFromFile(String path) {
        try {
            // Чтение файла и возврат содержимого
            return Files.readString(Path.of(path), StandardCharsets.UTF_8);
        } catch (IOException e) {
            // Ловим ошибку, если файл не найден или недоступен
            System.out.println("Error reading file.");
            return null;
        }
    }

    // Метод для записи в файл
    public void writeStringToFile(String inputPath, String content) {
        // Получение родительской папки из пути исходного файл
        Path parent = Path.of(inputPath).getParent();
        // Создание пути для нового файла с именем "output.txt"
        Path outputPath = parent.resolve("output.txt");
        try {
            Files.writeString(outputPath, content, StandardCharsets.UTF_8);
            System.out.println("The result is saved in output.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the output file.");
            e.printStackTrace();
        }
    }
}
