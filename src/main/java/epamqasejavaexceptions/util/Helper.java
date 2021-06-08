package epamqasejavaexceptions.util;

public class Helper {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static double normalizeDouble(double a) {
        return Math.round(a * 10d) / 10d;
    }

    public static double getNormalizedAverage(double sumOfValues, int numberOfValues) {
        return normalizeDouble(sumOfValues / numberOfValues);
    }
}
