package listfiles;

import java.io.*;
import java.util.*;

public class ListFiles {

    static File inputFile;

    private static String separator = System.getProperty("file.separator");

    static int countLevel(String string, String delimiter) {
        int count = 0;

        String str = string.substring(inputFile.getAbsolutePath().length());
        int index = str.lastIndexOf(delimiter);
        while (index != 0) {
            str = str.substring(0, index);
            index = str.lastIndexOf(delimiter);
            count++;
        }
        return count;
    }

    static String prefixString(int count) {
        StringBuffer outputBuffer = new StringBuffer(count);
        for (int i = 0; i < count; i++) {
            outputBuffer.append("-");
        }
        return outputBuffer.toString();
    }

    static void getFolderList(File dir, BufferedWriter bufferedWriter) {

        for (File file : dir.listFiles()) {
            if (file.isFile()) {
                String prefix = prefixString(countLevel(file.getAbsolutePath(), separator));
                try {
                    bufferedWriter.write(prefix, 0, prefix.length());
                    bufferedWriter.write(file.getName(), 0, file.getName().length());
                    bufferedWriter.newLine();
                } catch (FileNotFoundException exc) {
                    exc.printStackTrace();
                } catch (IOException exc) {
                    exc.printStackTrace();
                }
            }
        }

        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                String folder = file.getAbsolutePath();
                String prefix = prefixString(countLevel(file.getAbsolutePath(), separator));
                String out = folder.substring(folder.lastIndexOf(separator));
                try {
                    bufferedWriter.write(prefix, 0, prefix.length());
                    bufferedWriter.write(out, 0, out.length());
                    bufferedWriter.newLine();
                } catch (FileNotFoundException exc) {
                    exc.printStackTrace();
                } catch (IOException exc) {
                    exc.printStackTrace();
                }
                getFolderList(file, bufferedWriter);
            }
        }
    }

    static void getStatistics(File test) {

        int numFiles = 0;
        double fileNamesLength = 0.0;
        Map<String, Integer> listOfDir = new TreeMap<>();

        if (test.isFile() && test.exists()) {
            try (FileReader input = new FileReader(test);
                 BufferedReader bufferedReader = new BufferedReader(input);) {

                String line;
                String currentDir = "";

                while ((line = bufferedReader.readLine()) != null) {
                    if (line.indexOf(separator) >= 0) {
                        currentDir = line.substring(line.indexOf(separator) + 1);
                        listOfDir.put(currentDir, 0);
                        numFiles = 0;
                    } else {
                        numFiles++;
                        fileNamesLength += line.substring(line.lastIndexOf('-')+ 1).length();
                        listOfDir.put(currentDir, numFiles);
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            int numberOfAllFiles = 0;
            for (Integer number : listOfDir.values()) {
                numberOfAllFiles += number;
            }
            System.out.println("Содержание файлов в директориях: ");
            System.out.println(listOfDir);
            System.out.println();

            System.out.println("Количество директорий " + listOfDir.size());
            System.out.println("Количество файлов во всех директориях " + numberOfAllFiles);
            System.out.format("Среднее количество файлов в папке %.2f%n", ((double) numberOfAllFiles) / listOfDir.size());
            System.out.format("Средняя длина файла %.2f%n", fileNamesLength / numberOfAllFiles);
        }
    }

    public static void main(String[] args) {

        inputFile = new File(args[0]);

        if (inputFile.isDirectory() && inputFile.exists()) {
            File outputFile = new File("data" + separator + "output.txt");
            try (FileWriter fileWriter = new FileWriter(outputFile);
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {
                getFolderList(inputFile, bufferedWriter);
            } catch (FileNotFoundException exc) {
                exc.printStackTrace();
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        }

        if (inputFile.isFile() && inputFile.exists()) {
            getStatistics(inputFile);
        }
    }

}
