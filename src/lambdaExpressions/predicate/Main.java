package lambdaExpressions.predicate;

import lambdaExpressions.predicate.entities.Product;
import lambdaExpressions.predicate.utils.MyProductPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

public class Main {

    public static boolean predicateProduct(Product product) {
        return product.getPrice() >= 100.0;
    }

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        List<Product> products = new ArrayList<>();

        products.add(new Product("Tv", 900.00));
        products.add(new Product("Mouse", 50.00));
        products.add(new Product("Tablet", 350.0));
        products.add(new Product("HD Case", 80.90));

        Predicate<Product> condition = p -> p.getPrice() >= 100;

        products.removeIf(new MyProductPredicate());
        products.forEach(System.out::println);

        products.removeIf(Main::predicateProduct);
        products.forEach(System.out::println);

        products.removeIf(Product::predicateProduct);
        products.forEach(System.out::println);

        products.removeIf(condition);
        products.forEach(System.out::println);

        products.removeIf(p -> p.getPrice() >= 100);
        products.forEach(System.out::println);
    }
}
