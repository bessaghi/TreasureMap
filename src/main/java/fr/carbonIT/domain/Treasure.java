package fr.carbonIT.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import static fr.carbonIT.utils.GlobalConstants.LINE_BREAK;
import static fr.carbonIT.utils.GlobalConstants.TREASURE_HEADER;
import static java.lang.Integer.parseInt;

@Getter
@EqualsAndHashCode
public class Treasure implements MapObject {

    private final Coordinate coordinate;
    private int number;

    public Treasure(String x, String y, String number) {
        coordinate = Coordinate.parse(x, y);
        this.number = parseInt(number);
    }

    public static Treasure parse(String[] inputs) {
        return new Treasure(inputs[1], inputs[2], inputs[3]);
    }

    @Override
    public String toString() {
        return TREASURE_HEADER +
                LINE_BREAK +
                "T - %d - %d - %d".formatted(coordinate.getX(), coordinate.getY(), number);
    }

    @Override
    public InputType getInputType() {
        return InputType.T;
    }

    @Override
    public void putIn(TreasureMapJourney mapJourney) {
        mapJourney.getTreasures().add(this);
    }

    public void reduceOne() {
        number--;
    }
}
