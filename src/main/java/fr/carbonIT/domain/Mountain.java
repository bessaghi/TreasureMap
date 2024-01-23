package fr.carbonIT.domain;

import lombok.Data;

@Data
public class Mountain implements MapObject {

    private Coordinate coordinate;

    public Mountain(String x, String y) {
        coordinate = Coordinate.parse(x, y);
    }

    public static Mountain parse(String[] inputs) {
        return new Mountain(inputs[1], inputs[2]);
    }

    @Override
    public String toString() {
        return "M - %d - %d".formatted(coordinate.getX(), coordinate.getY());
    }

    @Override
    public InputType getInputType() {
        return InputType.M;
    }

    @Override
    public void putIn(TreasureMapJourney mapJourney) {
        mapJourney.getMountains().add(this);
    }
}
