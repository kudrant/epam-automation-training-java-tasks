package epamqasejavacollections.model;

import epamqasejavacollections.util.CsvParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Airline {
    public static final String FILENAME = "src/main/resources/aircraft.csv";
    private List<Aircraft> aircraft;

    public List<Aircraft> getAircraft() {
        return aircraft;
    }

    public void init() {
        aircraft = CsvParser.parseAircraft(FILENAME);
    }

    public List<Aircraft> sortAircraftByFlightRange() {
        List<Aircraft> sortedAircrafts = aircraft;
        Collections.sort(sortedAircrafts);
        return sortedAircrafts;
    }

    public int getTotalSeating() {
        int totalSeating = 0;
        for (Aircraft currentAircraft : aircraft
        ) {
            if (currentAircraft instanceof PassengerAircraft)
                totalSeating += ((PassengerAircraft) currentAircraft).getSeating();
        }
        return totalSeating;
    }

    public double getTotalCargoPayload() {
        double totalCargoPayload = 0.0;
        for (Aircraft currentAircraft : aircraft
        ) {
            if (currentAircraft instanceof FreightAircraft)
                totalCargoPayload += currentAircraft.cargoPayload;
        }
        return totalCargoPayload;
    }

    public List<Aircraft> getAircraftByFuelConsumption(double startFuelConsumptionRange, double endFuelConsumptionRange) {
        List<Aircraft> aircraftByFuelConsumption = new ArrayList<>();
        for (Aircraft currentAircraft : aircraft
        ) {
            if (currentAircraft.getFuelConsumption() > startFuelConsumptionRange && currentAircraft.getFuelConsumption() < endFuelConsumptionRange)
                aircraftByFuelConsumption.add(currentAircraft);
        }
        return aircraftByFuelConsumption;
    }
}
