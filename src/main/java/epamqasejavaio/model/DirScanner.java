package epamqasejavaio.model;

import epamqasejavaio.util.FileUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DirScanner {
    private final Logger logger = LogManager.getRootLogger();
    private final String FOLDER_ONE_LEVEL = "├───";
    private final String FOLDER_ONE_LEVEL_IS_LAST = "└───";
    private final String FILE_WHEN_FOLDER_HAS_CHILD = "│   ";
    private final String FILE_WHEN_FOLDER_HAS_NO_CHILD = "    ";
    private final String fileNamePattern = "[.A-Za-zА-Яа-я0-9_-]";
    private final StringBuilder sbFileTree = new StringBuilder();

    public StringBuilder scanDirectory(String stringPath, String prefix, boolean isChild) throws IOException {

        File baseDir = new File(stringPath);
        String filePrefix;
        String folderPrefix;
        boolean isLast;
        boolean baseDirHasChild;
        List<File> fileList = Arrays.asList(Objects.requireNonNull(baseDir.listFiles()));

        if (baseDir.isDirectory()) {
            int filesInDir = countFiles(baseDir);
            int foldersInDir = fileList.size() - filesInDir;
            baseDirHasChild = foldersInDir > 0;
            int folderCounter = 0;

            filePrefix = baseDirHasChild ? FILE_WHEN_FOLDER_HAS_CHILD : FILE_WHEN_FOLDER_HAS_NO_CHILD;

            if (!isChild)
                prefix = "";

            for (File file : fileList) {
                if (file.isFile()) {
                    sbFileTree.append(prefix).append(filePrefix).append(file.getName()).append("\n");
                }
            }
            sbFileTree.append(prefix).append(filePrefix).append("\n");

            for (File file : fileList) {
                filesInDir = countFiles(baseDir);
                foldersInDir = fileList.size() - filesInDir;

                if (file.isDirectory()) {

                    folderCounter++;
                    isLast = isLastFolder(foldersInDir, folderCounter);

                    folderPrefix = isLast ? FOLDER_ONE_LEVEL_IS_LAST : FOLDER_ONE_LEVEL;
                    sbFileTree.append(prefix).append(folderPrefix).append(file.getName()).append("\n");

                    String filePrefixForNextLevel;
                    filePrefixForNextLevel = !isLast ? FILE_WHEN_FOLDER_HAS_CHILD : FILE_WHEN_FOLDER_HAS_NO_CHILD;

                    scanDirectory(file.getPath(), prefix + filePrefixForNextLevel, true);
                }
            }
        }
        logger.info("Directory structure is saved to resources/filetree.txt");
        return sbFileTree;
    }


    public void showFileTreeSummary(String fileName) {
        int dirCounter = 1;
        int fileCounter = 0;
        double fileNamesLengthSum = 0.0;
        boolean insideDir = true;


        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (isFile(line)) {
                    fileCounter++;
                    fileNamesLengthSum += getFileName(line).length();
                }
                if (isDirectory(line)) {
                    dirCounter++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(fileName + " file statistics: " + "\n" +
                "Directories = " + dirCounter + "\n" +
                "Files = " + fileCounter + "\n" +
                "Average number of files in directory = " + fileCounter / dirCounter + "\n" +
                "Average filename length = " + FileUtil.getNormalizedAverage(fileNamesLengthSum, fileCounter));


    }

    private boolean isFile(String stringLine) {
        Pattern pattern = Pattern.compile(fileNamePattern);
        Matcher matcher = pattern.matcher(stringLine);
        int recordNameStartIndex;
        if (matcher.find()) {
            recordNameStartIndex = matcher.start();
            String prefix = stringLine.substring(recordNameStartIndex - 3, recordNameStartIndex);
            return prefix.equals("   ");
        }
        return false;
    }

    private String getFileName(String stringLine) {
        Pattern pattern = Pattern.compile(fileNamePattern);
        Matcher matcher = pattern.matcher(stringLine);
        if (matcher.find()) {
            return stringLine.substring(matcher.start());
        }
        return "";
    }

    private boolean isDirectory(String stringLine) {
        Pattern pattern = Pattern.compile(fileNamePattern);
        Matcher matcher = pattern.matcher(stringLine);
        int recordNameStartIndex;
        if (matcher.find()) {
            recordNameStartIndex = matcher.start();
            String prefix = stringLine.substring(recordNameStartIndex - 3, recordNameStartIndex);
            return prefix.equals("───");
        }
        return false;
    }


    private int countFiles(File baseDir) {
        int counter = 0;
        for (File file : baseDir.listFiles()
        ) {
            if (file.isFile())
                counter++;
        }
        return counter;
    }

    private boolean isLastFolder(int foldersTotal, int currentFolder) {
        return currentFolder >= foldersTotal;
    }

}
