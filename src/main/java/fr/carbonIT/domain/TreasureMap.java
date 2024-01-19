package fr.carbonIT.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TreasureMap implements MapObject {

    private Coordinate coordinate;

    public TreasureMap(String x, String y) {
        coordinate = Coordinate.parse(x, y);
    }

    public static TreasureMap parse(String[] inputs) {
        return new TreasureMap(inputs[1], inputs[2]);
    }

    @Override
    public InputType getInputType() {
        return InputType.C;
    }
}