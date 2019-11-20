package listfiles;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class FileFilledByIntegers {

    File inputFile;

    FileFilledByIntegers(File input, int integerNumber) {

        this.inputFile = input;
        Random random = new Random();
        Integer number;

        try (FileWriter fileWriter = new FileWriter(inputFile);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {
            while (integerNumber > 0) {
                number = random.nextInt();
                bufferedWriter.write(number.toString());
                bufferedWriter.newLine();
                integerNumber--;
            }
        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    void sortFileWithIntegers(File outputFile) {

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
}
