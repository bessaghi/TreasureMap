package fr.carbonIT.services;

import fr.carbonIT.domain.InputType;
import fr.carbonIT.domain.MapObject;

import static fr.carbonIT.utils.GlobalConstants.SEPARATOR;

public class InputReader {

    public MapObject read(String input) {
        String[] split = input.split(SEPARATOR);

        InputType inputType = InputType.valueOf(split[0]);

        return inputType.getParser().apply(split);
    }
}
