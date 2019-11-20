package listfiles.folder;

import java.io.*;

public class FolderContent {

    String separator = System.getProperty("file.separator");
    File inputFile;
    BufferedWriter bufferedWriter;

    FolderContent(File inputFile, BufferedWriter bufferedWriter) {
        this.inputFile = inputFile;
        this.bufferedWriter = bufferedWriter;
    }

    private int countLevel(String string, String delimiter) {
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

    private String prefixString(int count) {
        StringBuffer outputBuffer = new StringBuffer(count);
        for (int i = 0; i < count; i++) {
            outputBuffer.append("-");
        }
        return outputBuffer.toString();
    }

    void getFolderList(File dir) {

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
                getFolderList(file);
            }
        }
    }
}
