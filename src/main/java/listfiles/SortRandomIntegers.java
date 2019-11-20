package listfiles;

import java.io.*;

public class SortRandomIntegers {

    public static void main(String[] args) {

        String separator = System.getProperty("file.separator");
        File randomIntegers = new File("data" + separator + "RandomIntegers.txt");
        File sortedIntegers = new File("data" + separator + "SortedIntegers.txt");

        FileFilledByIntegers fileFilledByIntegers = new FileFilledByIntegers(randomIntegers, 10);

        fileFilledByIntegers.sortFileWithIntegers(sortedIntegers);
    }
}
