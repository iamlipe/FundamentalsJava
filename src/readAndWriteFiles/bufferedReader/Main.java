package readAndWriteFiles.bufferedReader;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String currentDirectory = System.getProperty("user.dir");
        String filePath = currentDirectory + File.separator + "in.txt";
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();

            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
