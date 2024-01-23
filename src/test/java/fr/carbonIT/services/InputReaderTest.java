package fr.carbonIT.services;

import fr.carbonIT.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static fr.carbonIT.domain.Direction.*;
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

    @Test
    void should_create_a_mountain_from_input() {
        MapObject mountain = inputReader.read("M - 1 - 1");

        assertThat(mountain.getInputType()).isEqualTo(InputType.M);
        assertThat(mountain.getCoordinate()).isEqualTo(new Coordinate(1, 1));
    }

    @Test
    void should_create_a_treasure_from_input() {
        Treasure treasure = (Treasure) inputReader.read("T - 0 - 3 - 2");

        assertThat(treasure.getInputType()).isEqualTo(InputType.T);
        assertThat(treasure.getCoordinate()).isEqualTo(new Coordinate(0, 3));
        assertThat(treasure.getNumber()).isEqualTo(2);
    }

    @Test
    void should_create_an_adventurer_from_input() {
        Adventurer adventurer = (Adventurer) inputReader.read("A - Indiana - 1 - 1 - S - AADADA");

        assertThat(adventurer.getInputType()).isEqualTo(InputType.A);
        assertThat(adventurer.getCoordinate()).isEqualTo(new Coordinate(1, 1));
        assertThat(adventurer.getName()).isEqualTo("Indiana");
        assertThat(adventurer.getOrientation()).isEqualTo(Orientation.S);
        assertThat(adventurer.getMovements()).containsExactly(A, A, D, A, D, A);

    }
}