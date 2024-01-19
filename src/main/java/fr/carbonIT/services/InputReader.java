package fr.carbonIT.services;

import fr.carbonIT.domain.InputType;
import fr.carbonIT.domain.MapObject;

public class InputReader {

    private static final String SEPARATOR = " - ";

    public MapObject read(String input) {
        String[] split = input.split(SEPARATOR);

        InputType inputType = InputType.valueOf(split[0]);

        return inputType.getFunction().apply(split);
    }
}
