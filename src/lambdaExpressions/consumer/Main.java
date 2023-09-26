package lambdaExpressions.consumer;

import lambdaExpressions.consumer.entities.Product;
import lambdaExpressions.consumer.utils.MyProductConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {

    public static void consumerProduct(Product product) {
        product.setPrice(product.getPrice() * 1.1);
    }

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        List<Product> products = new ArrayList<>();

        products.add(new Product("Tv", 900.00));
        products.add(new Product("Mouse", 50.00));
        products.add(new Product("Tablet", 350.0));
        products.add(new Product("HD Case", 80.90));

        Consumer<Product> consumer = p -> p.setPrice(p.getPrice() * 1.1);

        products.forEach(new MyProductConsumer());
        products.forEach(System.out::println);

        products.forEach(Main::consumerProduct);
        products.forEach(System.out::println);

        products.forEach(Product::consumerProduct);
        products.forEach(System.out::println);

        products.forEach(consumer);
        products.forEach(System.out::println);

        products.forEach(p -> p.setPrice(p.getPrice() * 1.1));
        products.forEach(System.out::println);
    }
}
