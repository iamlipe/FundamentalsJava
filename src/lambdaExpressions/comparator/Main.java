package lambdaExpressions.comparator;

import lambdaExpressions.comparator.entities.Product;
import lambdaExpressions.comparator.utils.MyProductComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static int compareProducts(Product p1, Product p2) {
        return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
    }

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        products.add(new Product("TV", 900.00));
        products.add(new Product("Notebook", 1200.00));
        products.add(new Product("Tablet", 450.00));

        Comparator<Product> comparator = (p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());

        products.sort(new MyProductComparator());
        products.forEach(System.out::println);

        products.sort(Main::compareProducts);
        products.forEach(System.out::println);
        
        products.sort(comparator);
        products.forEach(System.out::println);

        products.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));
        products.forEach(System.out::println);

        products.sort(Comparator.comparing(p -> p.getName().toUpperCase()));
        products.forEach(System.out::println);

    }
}
