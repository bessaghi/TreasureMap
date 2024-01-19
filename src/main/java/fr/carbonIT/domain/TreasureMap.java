package fr.carbonIT.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TreasureMap implements MapObject {

    private Coordinate coordinate;

    public static TreasureMap parse(String[] inputs) {
        return new TreasureMap(Coordinate.parse(inputs[1], inputs[2]));
    }

    @Override
    public InputType getInputType() {
        return InputType.C;
    }
}