package readAndWriteFiles.dataStore;

import readAndWriteFiles.dataStore.entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String currentDirectory = System.getProperty("user.dir");
        String inputPath = currentDirectory + File.separator + "/src/readAndWriteFiles/dataStore/input/source.csv";
        String outputPath = currentDirectory + File.separator + "/src/readAndWriteFiles/dataStore/output/summary.csv";
        List<Product> products = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputPath))) {
            String line = br.readLine();

            while (line != null) {
                String name = line.split(",")[0];
                double price = Double.parseDouble(line.split(",")[1]);
                int quantity = Integer.parseInt(line.split(",")[2]);

                Product product = new Product(name, price, quantity);

                products.add(product);

                line = br.readLine();
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))) {
                for (Product product : products) {
                    bw.write(product.toString());
                    bw.newLine();
                }

                System.out.println("CREATED!");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
