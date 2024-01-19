package fr.carbonIT.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Treasure implements MapObject {

    private Coordinate coordinate;

    @Override
    public InputType getInputType() {
        return InputType.T;
    }
}
