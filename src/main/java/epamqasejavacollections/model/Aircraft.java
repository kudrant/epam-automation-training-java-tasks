package epamqasejavacollections.model;

public abstract class Aircraft implements Comparable<Aircraft>{
    protected final String manufacturer;
    protected final String model;
    protected final double fuelCapacity;
    protected  final double flightRange;
    protected final double cargoPayload;

    public Aircraft(String manufacturer, String model, double fuelCapacity, double flightRange, double cargoPayload) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.fuelCapacity = fuelCapacity;
        this.flightRange = flightRange;
        this.cargoPayload = cargoPayload;
    }

    public double getFuelConsumption() { //Litres per kilometer
        return fuelCapacity / flightRange;
    }

    @Override
    public int compareTo(Aircraft a) {
        return (int)(this.flightRange - a.flightRange);
    }


}
