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
        for (Aircraft aircraft : aircraft
             ) {
            if (aircraft instanceof PassengerAircraft)
                totalSeating += ((PassengerAircraft) aircraft).getSeating();
        }
        return totalSeating;
    }

    public double getTotalCargoPayload() {
        double totalCargoPayload = 0.0;
        for (Aircraft aircraft : aircraft
             ) {
            if (aircraft instanceof FreightAircraft)
                totalCargoPayload += aircraft.cargoPayload;
        }
        return totalCargoPayload;
    }

    public List<Aircraft> getAircraftByFuelConsumption(double startFuelConsumptionRange, double endFuelConsumptionRange) {
        List<Aircraft> aircraftByFuelConsumption = new ArrayList<>();
        for (Aircraft aircraft : aircraft
             ) {
            if (aircraft.getFuelConsumption() > startFuelConsumptionRange && aircraft.getFuelConsumption()<endFuelConsumptionRange)
                aircraftByFuelConsumption.add(aircraft);
        }
        return aircraftByFuelConsumption;
    }
}
