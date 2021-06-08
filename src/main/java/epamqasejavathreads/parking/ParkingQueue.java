package epamqasejavathreads.parking;

import epamqasejavathreads.cars.Car;
import epamqasejavathreads.util.Helper;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class ParkingQueue implements Runnable {
    private final BlockingQueue<Car> carsQueue = new LinkedBlockingQueue<>();
    private final ThreadPoolExecutor parking;

    public ParkingQueue(ThreadPoolExecutor parking) {
        this.parking = parking;
        for (Runnable car : parking.getQueue()
        ) {
            carsQueue.add((Car) car);
        }
    }

    @Override
    public void run() {
        Car carToRemove;
        boolean runIndicator = true;
        while (runIndicator) {
            for (Car car : carsQueue
            ) {
                if (parking.getQueue().contains(car) && car.isWaitingTimeOver()) {
                    carToRemove = car;
                    parking.remove(carToRemove);
                    carsQueue.remove(carToRemove);
                    System.out.println("!! Car " + carToRemove.getId() + " left the Waiting line at "
                            + Helper.currentTimeInSeconds() + " due to out of time");
                }
            }
            if (carsQueue.isEmpty())
                runIndicator = false;
        }
    }

}
