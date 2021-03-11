package epamqasejavacollections.model;

public class FreightAircraft extends Aircraft {
    public FreightAircraft(String manufacturer, String model, double fuelCapacity, double flightRange, double cargoPayload) {
        super(manufacturer, model, fuelCapacity, flightRange, cargoPayload);
    }

    @Override
    public String toString() {
        return "Cargo Aircraft model: " + model +
                ", Flight Range = " + flightRange + " km, " +
                "Fuel Capacity = " + fuelCapacity + " L, " +
                "Cargo Payload = " + cargoPayload + " kg.";
    }
}
