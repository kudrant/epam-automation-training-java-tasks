package epamqasejavathreads;

import epamqasejavathreads.cars.CarGenerator;
import epamqasejavathreads.parking.ParkingQueue;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ParkingRunner {
    private static final int NUMBER_OF_PARKING_PLACES = 5;
    private static final int NUMBER_OF_CARS = 20;


    public static void main(String[] args) {
        System.out.println("=== Start parking ===");
        ThreadPoolExecutor parking =
                (ThreadPoolExecutor) Executors.newFixedThreadPool(NUMBER_OF_PARKING_PLACES);
        CarGenerator carGenerator = new CarGenerator(parking, NUMBER_OF_CARS);
        carGenerator.generateCars();
        Thread parkingQueue = new Thread( new ParkingQueue(parking));
        parkingQueue.setDaemon(true);
        parkingQueue.start();
        parking.shutdown();
    }
}
