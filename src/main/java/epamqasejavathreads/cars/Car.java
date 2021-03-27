package epamqasejavathreads.cars;


import epamqasejavathreads.util.Helper;

import java.util.concurrent.TimeUnit;

public class Car implements Runnable{
    private final int parkingTime;
    private long startParkingTime;
    private final long carArriveTime;
    private final long maxWaitingTime;
    private final int id;

    public Car(int id, long carArriveTime, int parkingTime, long maxWaitingTime) {
        this.id = id;
        this.parkingTime = parkingTime;
        this.maxWaitingTime = maxWaitingTime;
        this.carArriveTime = carArriveTime;
        System.out.println("++ Car " + id + " arrived at " + this.carArriveTime
                + " with " + maxWaitingTime + " seconds queue waiting time");
    }

    @Override
    public synchronized void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setStartParkingTime();
        System.out.println("@ Car " + id + " have parked at " + startParkingTime + " for " + parkingTime + " seconds");
        try {
            TimeUnit.SECONDS.sleep(parkingTime);
            System.out.println("-- Car " + id + " left the parking at " + Helper.currentTimeInSeconds());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isWaitingTimeOver() {
        return Helper.currentTimeInSeconds() > (carArriveTime + maxWaitingTime);
    }

    public void setStartParkingTime() {
        this.startParkingTime = Helper.currentTimeInSeconds();
    }

    public int getId() {
        return id;
    }


}
