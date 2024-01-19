package fr.carbonIT.services;

import fr.carbonIT.domain.Coordinate;
import fr.carbonIT.domain.InputType;
import fr.carbonIT.domain.MapObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InputReaderTest {

    private InputReader inputReader;

    @BeforeEach
    void setUp() {
        inputReader = new InputReader();
    }

    @Test
    void should_create_a_map_from_input() {
        MapObject map = inputReader.read("C - 3 - 4");

        assertThat(map.getInputType()).isEqualTo(InputType.C);
        assertThat(map.getCoordinate()).isEqualTo(new Coordinate(3, 4));
    }

}