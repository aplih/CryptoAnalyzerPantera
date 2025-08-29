package com.javarush.toporov;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandler {
    public String readStringFromFile(String path) {
        try {
            return Files.readString(Path.of(path), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Error reading file.");
            return null;
        }
    }

    public void writeStringToFile(String inputPath, String content) {
        Path parent = Path.of(inputPath).getParent();
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
