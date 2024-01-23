package fr.carbonIT.services;

import fr.carbonIT.exceptions.FileCreationFailedException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileWriter {

    public void writeInFile(String name, List<String> results) {
        Path path = Path.of("outputs" + name);

        try {
            Files.write(path, results, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            throw new FileCreationFailedException();
        }
    }
}
