package fr.carbonIT.services;

import fr.carbonIT.domain.TreasureMapJourney;

public class AdventurerJourney {

    private final FileReader fileReader;
    private final FileWriter fileWriter;

    public AdventurerJourney() {
        this.fileReader = new FileReader();
        this.fileWriter = new FileWriter();
    }

    public void start(String path) {
        TreasureMapJourney mapJourney = new TreasureMapJourney();
        fileReader.read(path)
                .forEach(o -> o.putIn(mapJourney));

        mapJourney.computeOutput();

        fileWriter.writeInFile(path, mapJourney.printResult());
    }

}
