package epamqasejavathreads.cars;

import epamqasejavathreads.util.Helper;

import java.util.Random;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CarGenerator {
    private final ThreadPoolExecutor parking;
    private final int carCount;

    public CarGenerator(ThreadPoolExecutor parking, int carCount) {
        this.parking = parking;
        this.carCount = carCount;
    }


    public void generateCars() {
        for (int i = 1; i <= carCount; i++) {
            parking.execute(new Car(i, Helper.currentTimeInSeconds(),
                    getRandomParkingTime(), getRandomMaxWaitingTime()));
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private int getRandomParkingTime() {
        return new Random().nextInt(9) + 1;
    }

    private int getRandomMaxWaitingTime() {
        return new Random().nextInt(4) + 1;
    }


}
