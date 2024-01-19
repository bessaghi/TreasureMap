package fr.carbonIT.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import static java.lang.Integer.parseInt;

@Data
@AllArgsConstructor
public class Treasure implements MapObject {

    private Coordinate coordinate;
    private int number;

    public Treasure(String x, String y, String number) {
        coordinate = Coordinate.parse(x, y);
        this.number = parseInt(number);
    }

    public static Treasure parse(String[] inputs) {
        return new Treasure(inputs[1], inputs[2], inputs[3]);
    }

    @Override
    public InputType getInputType() {
        return InputType.T;
    }
}
