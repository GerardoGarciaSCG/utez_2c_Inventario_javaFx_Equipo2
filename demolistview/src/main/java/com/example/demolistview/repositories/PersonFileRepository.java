package com.example.demolistview.repositories;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class PersonFileRepository {

    private final Path filePath = Paths.get("data", "persons.csv");

    private void ensureFileExist() throws IOException {
        // agregar validacion para crear
        if (Files.notExists(filePath)) {
            Files.createFile(filePath);
        }
    }

    public List<String> readAllLines() throws IOException {
        ensureFileExist();
        return Files.readAllLines(filePath, StandardCharsets.UTF_8);
    }


    public void  appendNewLine(String Line) throws IOException {
     Files.writeString(filePath,Line+System.lineSeparator(),StandardCharsets.UTF_8,
             StandardOpenOption.APPEND);

    }
    public void saveFile(List<String> lines) throws IOException{
        Files.write(filePath,lines,StandardCharsets.UTF_8,StandardOpenOption.TRUNCATE_EXISTING);

    }

}