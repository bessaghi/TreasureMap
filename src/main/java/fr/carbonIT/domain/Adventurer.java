package fr.carbonIT.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

import static fr.carbonIT.utils.GlobalConstants.ADVENTURER_HEADER;
import static fr.carbonIT.utils.GlobalConstants.LINE_BREAK;

@Data
@Builder
@AllArgsConstructor
public class Adventurer implements MapObject {

    private String name;
    private Coordinate coordinate;
    private Orientation orientation;
    private List<Direction> movements;
    private int treasures;

    @Override
    public InputType getInputType() {
        return InputType.A;
    }

    @Override
    public void putIn(TreasureMapJourney mapJourney) {
        mapJourney.getAdventurers().add(this);
    }

    @Override
    public String toString() {
        return ADVENTURER_HEADER + LINE_BREAK +
                "A - %s - %d - %d - %s - %d".formatted(name, coordinate.getX(), coordinate.getY(), orientation, treasures);
    }

    public static Adventurer parse(String[] input) {
        return Adventurer.builder()
                .name(input[1])
                .coordinate(Coordinate.parse(input[2], input[3]))
                .orientation(Orientation.valueOf(input[4]))
                .movements(toDirections(input))
                .build();
    }

    private static List<Direction> toDirections(String[] input) {
        return input[5].chars().mapToObj(c -> (char) c)
                .map(String::valueOf)
                .map(Direction::valueOf)
                .toList();
    }


    public void goStraight(TreasureMapJourney mapJourney) {
        Coordinate destination = orientation.getMove().apply(coordinate.getX(), coordinate.getY());
        if (reachedLimits(destination, mapJourney.getMap().getCoordinate())
                && hasObstacles(destination, mapJourney.getMountains())) {
            return;
        }
        coordinate = destination;
        computeTreasures(mapJourney.getTreasures());
    }

    private boolean reachedLimits(Coordinate destination, Coordinate mapSize) {
        return destination.getX() < 0
                && destination.getY() < 0
                && destination.getX() > mapSize.getX()
                && destination.getY() > mapSize.getY();
    }

    private void computeTreasures(List<Treasure> treasures) {
        treasures.stream()
                .filter(it -> it.getCoordinate().equals(coordinate))
                .peek(t -> this.treasures++)
                .forEach(Treasure::reduceOne);
    }

    private boolean hasObstacles(Coordinate destination, List<Mountain> mountains) {
        return mountains.stream().anyMatch(it -> it.getCoordinate().equals(destination));
    }

    public void turnLeft() {
        orientation = orientation.turnLeft();
    }

    public void turnRight() {
        orientation = orientation.turnRight();
    }
}