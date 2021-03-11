package epamqasejavacollections.model;

public class PassengerAircraft extends Aircraft {
    private final int seating;

    public PassengerAircraft(String manufacturer, String model, double fuelCapacity, double flightRange, double cargoPayload, int seating) {
        super(manufacturer, model, fuelCapacity, flightRange, cargoPayload);
        this.seating = seating;
    }

    public double getSeating() {
        return seating;
    }

    @Override
    public String toString() {
        return "Passenger Aircraft model: " + model +
                ", Flight Range = " + flightRange + " km, " +
                "Fuel Capacity = " + fuelCapacity + " L, " +
                "Seating = " + seating + " seats";
    }

}
