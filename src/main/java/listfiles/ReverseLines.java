package listfiles;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReverseLines {

    public static void main(String[] args) {

        String separator = System.getProperty("file.separator");
        File poetry = new File("data" + separator + "poetry.txt");
        File reversedPoetry = new File("data" + separator + "txt.yrteop");

        List<String> listString = new ArrayList<>();

        try (FileReader fileReader = new FileReader(poetry);
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

        try (FileWriter fileWriter = new FileWriter(reversedPoetry);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {

            for (String str : listString) {
                for (Character ch : str.toCharArray()) {
                    characterList.add(ch);
                }

                for (int ch = characterList.size(); ch > 0; ch--) {
                    bufferedWriter.write(characterList.get(ch - 1));
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
}
