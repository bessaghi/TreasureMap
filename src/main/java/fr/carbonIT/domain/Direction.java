package fr.carbonIT.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.BiConsumer;

@Getter
@AllArgsConstructor
public enum Direction {
    A(Adventurer::goStraight),
    G((a, t) -> a.turnLeft()),
    D((a, t) -> a.turnRight());

    private final BiConsumer<Adventurer, TreasureMapJourney> move;
}
