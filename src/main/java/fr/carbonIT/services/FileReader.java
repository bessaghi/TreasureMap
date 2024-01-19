package fr.carbonIT.services;

import fr.carbonIT.domain.MapObject;
import fr.carbonIT.exceptions.UnreadableFileException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Optional.ofNullable;

public class FileReader {

    private final InputReader inputReader;

    public FileReader() {
        this.inputReader = new InputReader();
    }

    public List<MapObject> read(String path) {
        return readFile(path)
                .stream()
                .map(inputReader::read)
                .toList();
    }

    private static List<String> readFile(String filePath) {
        return ofNullable(FileReader.class.getResourceAsStream(filePath))
                .map(inputStream -> new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                .map(BufferedReader::new)
                .map(BufferedReader::lines)
                .map(s -> s.filter(it -> !it.startsWith("#")))
                .map(Stream::toList)
                .orElseThrow(UnreadableFileException::new);
    }
}
