import java.io.*;

public class CopyFile {
    public static void main(String args[]) throws IOException {

        int input;
        if (args.length != 2) {
            System.out.println("Использование: CopyFile откуда куда ");
            return;
        }

        try (FileInputStream fileInput = new FileInputStream(args[0]);
             FileOutputStream fileOutput = new FileOutputStream(args[1])) {
            do {
                input = fileInput.read();
                if (input != -1) fileOutput.write(input);
            } while (input != -1);

        } catch (IOException exc) {
            System.out.println("Ошибка ввода-вывода: " + exc);

        }
    }
}

