package fr.carbonIT.services;

import fr.carbonIT.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FileReaderTest {

    private FileReader fileReader;

    @BeforeEach
    void setUp() {
        fileReader = new FileReader();
    }

    @Test
    void should_create_correct_inputs_from_file() {
        List<MapObject> actual = fileReader.read("/treasure-map-example.txt");

        assertThat(actual).containsExactly(
                new TreasureMap("3", "4"),
                new Mountain("1", "0"),
                new Mountain("2", "1"),
                new Treasure("0", "3", "2"),
                new Treasure("1", "3", "3"),
                Adventurer.builder()
                        .name("Lara")
                        .coordinate(new Coordinate(1, 1))
                        .orientation(Orientation.S)
                        .movements("AADADAGGA".toCharArray())
                        .build()
        );
    }

    @Test
    void should_ignore_comment_lines() {
        List<MapObject> actual = fileReader.read("/treasure-map-with-comments.txt");

        assertThat(actual).containsExactly(
                new TreasureMap("3", "4"),
                new Mountain("1", "0")
        );
    }
}