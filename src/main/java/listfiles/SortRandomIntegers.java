package listfiles;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class SortRandomIntegers {

    private static String separator = System.getProperty("file.separator");

    static void fillFileByRandomIntegers(File fileinput) {

        Random random = new Random();
        Integer number;
        int i = 0;
        try (FileWriter fileWriter = new FileWriter(fileinput);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {
            while (i < 10) {
                number = random.nextInt();
                bufferedWriter.write(number.toString());
                bufferedWriter.newLine();
                i++;
            }
        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    static void sortFileWithIntegers(File inputFile, File outputFile) {

        List<Integer> listInteger = new ArrayList<>();

        try (FileReader fileReader = new FileReader(inputFile);
             BufferedReader bufferedReader = new BufferedReader(fileReader);) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                listInteger.add(Integer.parseInt(line));
            }
        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
        } catch (IOException exc) {
            exc.printStackTrace();
        }

        listInteger.sort(Comparator.<Integer>naturalOrder());

        try (FileWriter fileWriter = new FileWriter(outputFile);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {
            for (Integer i : listInteger) {
                bufferedWriter.write(i.toString());
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    public static void main(String[] args) {

        File randomIntegers = new File("data" + separator + "RandomIntegers.txt");
        File sortedIntegers = new File("data" + separator + "SortedIntegers.txt");

        fillFileByRandomIntegers(randomIntegers);

        sortFileWithIntegers(randomIntegers, sortedIntegers);

    }

}
