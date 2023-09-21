package vectorAndMatrix.averagePrice;

import vectorAndMatrix.averagePrice.entities.Product;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Product[] vector = new Product[n];

        for (int i = 0; i < n; i++) {
            sc.nextLine();
            String name = sc.nextLine();

            double price = sc.nextDouble();
            vector[i] = new Product(name, price);
        }

        double sum = 0.0;

        for (int i = 0; i < 3; i++) {
            sum += vector[i].getPrice();
        }

        double avg = sum / n;

        System.out.printf("AVERAGE PRICE: %.2f", avg);

        sc.close();
    }

}
