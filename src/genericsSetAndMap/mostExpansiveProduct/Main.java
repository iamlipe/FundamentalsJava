package genericsSetAndMap.mostExpansiveProduct;

import genericsSetAndMap.mostExpansiveProduct.entities.Product;
import genericsSetAndMap.mostExpansiveProduct.service.CalculationService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        String currentDirectory = System.getProperty("user.dir");
        String filePath = currentDirectory + File.separator + "/src/genericsSetAndMap/mostExpansiveProduct/input/products.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            List<Product> products = new ArrayList<>();

            String line = br.readLine();

            while (line != null) {
                String name = line.split(",")[0];
                double price = Double.parseDouble(line.split(",")[1]);

                Product product = new Product(name, price);

                products.add(product);

                line = br.readLine();
            }

            for (Product product : products) {
                System.out.println(product);
            }

            Product mostExpansive = CalculationService.max(products);

            System.out.println();
            System.out.println("Most expansive:");
            System.out.println(mostExpansive);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
