package epamqasejavacollections;

import epamqasejavacollections.controller.Controller;


/**
 * Airline. Determine the aircraft hierarchy. Create an airline.
 * Calculate the total seating and cargo payload.
 * Sort the company's aircraft by flight range.
 * Find an aircraft in the company that matches a given range of fuel consumption.
 */
public class App {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.initController();
    }
}
