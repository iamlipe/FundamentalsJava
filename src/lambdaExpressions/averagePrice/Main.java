package lambdaExpressions.averagePrice;

import lambdaExpressions.averagePrice.entities.Product;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        String currentDirectory = System.getProperty("user.dir");
        String filePath = currentDirectory + File.separator + "/src/lambdaExpressions/averagePrice/input/products.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            List<Product> products = new ArrayList<>();

            String line = br.readLine();

            while (line != null) {
                String[] fields = line.split(",");

                Product product = new Product(fields[0], Double.parseDouble(fields[1]));
                products.add(product);

                line = br.readLine();
            }

            double sum = products.stream()
                    .map(p -> p.getPrice())
                    .reduce(0.0, (a, b) -> a + b);

            double average = sum / products.size();

            System.out.println("Average price: " + String.format("%.2f", average));

            Comparator<String> comparator = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

            List<String> names = products.stream()
                    .filter(p -> p.getPrice() < average)
                    .map(p -> p.getName())
                    .sorted(comparator.reversed())
                    .collect(Collectors.toList());

            names.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
