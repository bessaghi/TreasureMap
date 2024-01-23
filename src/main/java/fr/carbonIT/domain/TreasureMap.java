package fr.carbonIT.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class TreasureMap implements MapObject {

    private final Coordinate coordinate;

    public TreasureMap(String x, String y) {
        coordinate = Coordinate.parse(x, y);
    }

    public static TreasureMap parse(String[] inputs) {
        return new TreasureMap(inputs[1], inputs[2]);
    }

    @Override
    public String toString() {
        return "C - %d - %d".formatted(coordinate.getX(), coordinate.getY());
    }

    @Override
    public InputType getInputType() {
        return InputType.C;
    }

    @Override
    public void putIn(TreasureMapJourney mapJourney) {
        mapJourney.setMap(this);
    }
}