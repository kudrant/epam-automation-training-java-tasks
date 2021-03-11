package epamqasejavacollections.controller;

import static epamqasejavacollections.controller.Controller.*;

// My try to use this: https://www.javacodegeeks.com/2019/03/featured-enum-instead-switch.html
public enum MenuItem {
    ONE("1") {
        @Override public void action() {
            view.showAircraft(airline.getAircraft(), "All aircraft of Airline");
        }
    },
    TWO("2") {
        @Override public void action() {
            view.showTotalSeatings(airline);
        }
    },
    THREE("3") {
        @Override public void action() {
            view.showTotalCargoPayload(airline);
        }
    },
    FOUR("4") {
        @Override public void action() {
            view.showAircraft(airline.sortAircraftByFlightRange(), "Aircraft sorted by flight range");
        }
    },
    FIVE("5") {
        @Override public void action() {
            view.showAircraft(airline.getAircraftByFuelConsumption(STARTFUELCONSUMPTION, ENDFUELCONSUMPTION), "Airplanes with 8.7-9.3 L/km fuel consumption" );
        }
    },
    QUIT("Q") {
        @Override public void action() {
            System.exit(0);
        }
    };

    private final String item;

    MenuItem(String item) {
        this.item = item;
    }

    public abstract void action();
}
