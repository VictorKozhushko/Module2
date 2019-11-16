package listfiles;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReverseLines {

    private static String separator = System.getProperty("file.separator");

    static void reverseLines(File inputFile, File outputFile) {
        List<String> listString = new ArrayList<>();

        try (FileReader fileReader = new FileReader(inputFile);
             BufferedReader bufferedReader = new BufferedReader(fileReader);) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                listString.add(line);
            }
        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
        } catch (IOException exc) {
            exc.printStackTrace();
        }

        List<Character> characterList = new ArrayList<Character>();

        try (FileWriter fileWriter = new FileWriter(outputFile);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {

            for (String str : listString) {
                for (Character ch : str.toCharArray()) {
                    characterList.add(ch);
                }

                for (int i = characterList.size(); i > 0; i--) {
                    bufferedWriter.write(characterList.get(i - 1));
                }
                bufferedWriter.newLine();
                characterList.clear();
            }
        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    public static void main(String[] args) {

        File poetry = new File("data" + separator + "poetry.txt");
        File reversedPoetry = new File("data" + separator + "txt.yrteop");

        reverseLines(poetry, reversedPoetry);
    }

}
