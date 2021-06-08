package epamqasejavacollections.util;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import epamqasejavacollections.model.Aircraft;
import epamqasejavacollections.model.FreightAircraft;
import epamqasejavacollections.model.PassengerAircraft;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {
    public static List<Aircraft> parseAircraft(String filename) {
        List<Aircraft> aircraft = new ArrayList<>();
        try (FileReader fileReader = new FileReader(filename);
             CSVReader reader = new CSVReader(fileReader)) {
            String[] line;    //CSV columns: manufacturer,model,type,fuelCapacity,flightRange,cargoPayload,seating,quantity

            while ((line = reader.readNext()) != null) {
                String manufacturer = line[0];
                String model = line[1];
                String aircraftType = line[2];
                Double fuelCapacity = Double.valueOf(line[3]);
                Double flightRange = Double.valueOf(line[4]);
                Double cargoPayload = Double.valueOf(line[5]);
                int seating = Integer.valueOf(line[6]);
                for (int i = 0; i < Integer.valueOf(line[7]); i++) {
                    if (aircraftType.equals("p"))
                        aircraft.add(new PassengerAircraft(manufacturer, model, fuelCapacity, flightRange, cargoPayload, seating));
                    else
                        aircraft.add(new FreightAircraft(manufacturer, model, fuelCapacity, flightRange, cargoPayload));
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        return aircraft;
    }
}
