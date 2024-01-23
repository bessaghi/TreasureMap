package fr.carbonIT.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TreasureMapJourney {

    private TreasureMap map;
    private List<Mountain> mountains = new ArrayList<>();
    private List<Treasure> treasures = new ArrayList<>();
    private List<Adventurer> adventurers = new ArrayList<>();

    public void computeOutput() {
        adventurers.forEach(it -> it.getMovements()
                .forEach(m -> m.getMove().accept(it, this)));
    }

    public List<String> printResult() {
        List<String> results = new ArrayList<>();
        results.add(map.toString());
        results.addAll(mountains.stream()
                .map(Mountain::toString)
                .toList());
        results.addAll(treasures.stream()
                        .filter(it -> it.getNumber() != 0)
                .map(Treasure::toString)
                .toList());
        results.addAll(adventurers.stream()
                .map(Adventurer::toString)
                .toList());
        return results;
    }
}
