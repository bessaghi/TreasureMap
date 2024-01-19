package fr.carbonIT.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Mountain implements MapObject {

    private Coordinate coordinate;

    public Mountain(String x, String y) {
        coordinate = Coordinate.parse(x, y);
    }

    public static Mountain parse(String[] inputs) {
        return new Mountain(inputs[1], inputs[2]);
    }

    @Override
    public InputType getInputType() {
        return InputType.M;
    }
}
