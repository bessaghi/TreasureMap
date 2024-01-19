package fr.carbonIT.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Function;

@Getter
@AllArgsConstructor
public enum InputType {

    C(TreasureMap::parse),
    M(Mountain::parse),
    T(Treasure::parse),
    A(Adventurer::parse);

    private final Function<String[], MapObject> function;
}
