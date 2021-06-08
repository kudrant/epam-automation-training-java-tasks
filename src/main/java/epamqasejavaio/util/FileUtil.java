package epamqasejavaio.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {

    public static void writeToResources(String fileName, StringBuilder sb) {
        try (FileWriter fileWriter = new FileWriter("src/main/resources/" + fileName)) {
            fileWriter.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double normalizeDouble(double a) {
        return Math.round(a * 10d) / 10d;
    }

    public static double getNormalizedAverage(double sumOfValues, int numberOfValues) {
        return normalizeDouble(sumOfValues / numberOfValues);
    }
}
