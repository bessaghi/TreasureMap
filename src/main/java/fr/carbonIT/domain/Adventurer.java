package fr.carbonIT.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Adventurer implements MapObject {

    private String name;
    private Coordinate coordinate;
    private Orientation orientation;
    private char[] movements;

    @Override
    public InputType getInputType() {
        return InputType.A;
    }

    public static Adventurer parse(String[] input) {
        return Adventurer.builder()
                .name(input[1])
                .coordinate(Coordinate.parse(input[2], input[3]))
                .orientation(Orientation.valueOf(input[4]))
                .movements(input[5].toCharArray())
                .build();
    }
}