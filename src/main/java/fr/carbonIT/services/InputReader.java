package fr.carbonIT.services;

import fr.carbonIT.domain.Coordinate;
import fr.carbonIT.domain.TreasureMap;

public class InputReader {
    public TreasureMap read(String input) {
        String[] split = input.split(" - ");

        return new TreasureMap(Coordinate.parse(split[1], split[2]));
    }
}
