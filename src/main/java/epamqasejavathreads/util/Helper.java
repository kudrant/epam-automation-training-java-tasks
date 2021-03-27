package epamqasejavathreads.util;

public class Helper {

    public static long currentTimeInSeconds() {
        return System.nanoTime() / 1_000_000_000;
    }
}
