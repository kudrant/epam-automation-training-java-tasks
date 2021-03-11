package epamqasejavacollections;

import epamqasejavacollections.controller.Controller;


/**
 * Airline. Determine the aircraft hierarchy. Create an airline.
 * Calculate the total capacity and lifting capacity.
 * Sort the company's aircraft by range.
 * Find an aircraft in the company that matches a given range of fuel consumption parameters.
 */
public class App 
{
    public static void main( String[] args )
    {
        Controller controller = new Controller();
        controller.initController();
    }
}
