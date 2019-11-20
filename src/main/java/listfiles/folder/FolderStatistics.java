package listfiles.folder;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class FolderStatistics {

    String separator = System.getProperty("file.separator");
    File folderFile;

    FolderStatistics(File folderFile) {

        this.folderFile = folderFile;
    }

    void getStatistics() {


        int numFiles = 0;
        double fileNamesLength = 0.0;
        Map<String, Integer> listOfDir = new TreeMap<>();

        if (folderFile.isFile() && folderFile.exists()) {
            try (FileReader input = new FileReader(folderFile);
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
                        fileNamesLength += line.substring(line.lastIndexOf('-') + 1).length();
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
}
