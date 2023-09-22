package readAndWriteFiles.fileReader;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String currentDirectory = System.getProperty("user.dir");
        String filePath = currentDirectory + File.separator + "in.txt";
        File file = new File(filePath);

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Error opening file: " + e.getMessage());
        } finally {
            System.out.println("Finally executed!");
        }
    }
}
