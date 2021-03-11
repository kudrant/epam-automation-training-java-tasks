package epamqasejavacollections.view;

import epamqasejavacollections.model.Airline;
import epamqasejavacollections.model.Aircraft;

import java.util.List;

public class View {

    public void printMenuItems() {
        System.out.println("\n" + "Please input your choice:");
        System.out.println("1 - show all aircraft of Airline");
        System.out.println("2 - show total number of seatings");
        System.out.println("3 - show total cargo payload");
        System.out.println("4 - sort aircraft by flight range");
        System.out.println("5 - show aircraft with 8.7-9.3 L/km fuel consumption");
        System.out.println("q - quit");
    }


    public void showAircraft(List<Aircraft> aircraft, String headMessage) {
        if (aircraft.isEmpty()) {
            System.out.println("Aircraft list is empty");
        } else {
            System.out.println(headMessage);
            for (Aircraft craft : aircraft
            ) {
                System.out.println(craft);
            }
        }
    }

    public void showTotalSeatings(Airline airline) {
        System.out.println("Airline's total number of seating: " + airline.getTotalSeatings());
    }

    public void showTotalCargoPayload(Airline airline) {
        System.out.println("Airline's total cargo payload: " + airline.getTotalCargoPayload());
    }

}
