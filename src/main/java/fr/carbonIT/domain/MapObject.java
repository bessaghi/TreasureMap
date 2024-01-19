package fr.carbonIT.domain;

public interface MapObject {

    Coordinate getCoordinate();

    InputType getInputType();

    default int getNumber() {
        return 0;
    }
}
