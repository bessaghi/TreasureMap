package fr.carbonIT.services;

import fr.carbonIT.domain.Coordinate;
import fr.carbonIT.domain.InputType;
import fr.carbonIT.domain.MapObject;

public class InputReader {

    public static final String SEPARATOR = " - ";

    public MapObject read(String input) {
        String[] split = input.split(SEPARATOR);

        InputType inputType = InputType.valueOf(split[0]);

        return inputType.getFunction().apply(Coordinate.parse(split[1], split[2]));
    }
}
