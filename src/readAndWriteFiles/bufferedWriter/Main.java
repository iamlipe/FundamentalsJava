package readAndWriteFiles.bufferedWriter;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        String[] lines = new String[]{"Boa noite"};

        String currentDirectory = System.getProperty("user.dir");
        String filePath = currentDirectory + File.separator + "out.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
