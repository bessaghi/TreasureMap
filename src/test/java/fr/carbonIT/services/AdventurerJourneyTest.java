package fr.carbonIT.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

class AdventurerJourneyTest {

    private AdventurerJourney adventurerJourney;

    @BeforeEach
    void setUp() {
        adventurerJourney = new AdventurerJourney();
    }

    @Test
    void should_write_execution_of_the_file() {
        adventurerJourney.start("/treasure-map-example.txt");

        File expected = new File("outputs/treasure-map-example-expected.txt");
        File actual = new File("outputs/treasure-map-example.txt");

        assertThat(actual).hasSameTextualContentAs(expected);
    }

}