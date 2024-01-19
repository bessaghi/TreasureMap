package fr.carbonIT.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import static java.lang.Integer.parseInt;

@Data
@AllArgsConstructor
public class Coordinate {

    private int x;
    private int y;

    public static Coordinate parse(String x, String y) {
        return new Coordinate(parseInt(x), parseInt(y));
    }
}
