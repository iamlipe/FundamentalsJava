package inheritanceAndPolymorphism.managerStore;

import inheritanceAndPolymorphism.managerStore.entities.ImportedProduct;
import inheritanceAndPolymorphism.managerStore.entities.Product;
import inheritanceAndPolymorphism.managerStore.entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the numbers of products: ");
        int numberProducts = sc.nextInt();
        List<Product> products = new ArrayList<>();

        for (int i = 1; i <= numberProducts; i++) {
            System.out.println("Product #" + i + " data:");

            System.out.print("Common, used or imported (c/u/i)? ");

            char typeProduct;

            do {
                typeProduct = sc.next().toLowerCase().charAt(0);

                if (typeProduct != 'c' && typeProduct != 'u' && typeProduct != 'i') {
                    System.out.println("Enter a valid answer");
                }
            } while (typeProduct != 'c' && typeProduct != 'u' && typeProduct != 'i');

            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            if (typeProduct == 'c') {
                Product product = new Product(name, price);
                products.add(product);
            }

            if (typeProduct == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                String date = sc.next();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                LocalDate manufactureDate = LocalDate.parse(date, formatter);

                Product product = new UsedProduct(name, price, manufactureDate);
                products.add(product);
            }

            if (typeProduct == 'i') {
                System.out.print("Customs fee: ");
                double customsFee = sc.nextDouble();

                Product product = new ImportedProduct(name, price, customsFee);
                products.add(product);
            }
        }

        System.out.println("PRICE TAGS:");

        for (Product p : products) {
            System.out.println(p.getName() + " " + p.priceTag());
        }

    }
}
