package fr.carbonIT.domain;

public interface MapObject {

    Coordinate getCoordinate();

    InputType getInputType();

    void putIn(TreasureMapJourney mapJourney);
}
