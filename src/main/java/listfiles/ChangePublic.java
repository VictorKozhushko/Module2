package listfiles;

import java.io.*;

public class ChangePublic {

    public static void main(String[] args) {

        String separator = System.getProperty("file.separator");
        File input = new File("data" + separator + "CopyFile.java");
        File output = new File("data" + separator + "ChangedCopyFile.java");

        try (FileReader fileReader = new FileReader(input);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter(output);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        ) {
            String inline;
            String outline;
            while ((inline = bufferedReader.readLine()) != null) {
                outline = inline.replace("public", "private");

                bufferedWriter.write(outline, 0, outline.length());
                bufferedWriter.newLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
