package fr.carbonIT.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Function;

@Getter
@AllArgsConstructor
public enum InputType {

    C(TreasureMap::new),
    M(Mountain::new),
    T(Treasure::new);

    private final Function<Coordinate, MapObject> function;
}
