package listfiles.folder;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.*;

public class ListFiles {

    public static void main(String[] args) {

        File inputFile;
        Scanner input = new Scanner(System.in);
        String fileName;

        if (args.length == 0) {
            System.out.println("При первом вызове введите путь к директории, при втором путь к output.txt: ");
            fileName = input.nextLine();
            inputFile = new File(fileName);
        } else inputFile = new File(args[0]);

        String separator = System.getProperty("file.separator");

        if (inputFile.isDirectory() && inputFile.exists()) {
            File outputFile = new File("data"+separator+"output.txt");
            try( FileWriter fileWriter = new FileWriter(outputFile);
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);)
            {
                FolderContent folderContent = new FolderContent(inputFile, bufferedWriter);
                folderContent.getFolderList(inputFile);
            }
            catch(FileNotFoundException exc)
            {
                exc.printStackTrace();
            }catch (IOException exc)
            {
                exc.printStackTrace();
            }

        }

        if (inputFile.isFile() && inputFile.exists()) {
            FolderStatistics folderStatistics = new FolderStatistics(inputFile);
            folderStatistics.getStatistics();
        }
    }

}
