package lambdaExpressions.function;

import lambdaExpressions.function.entities.Product;
import lambdaExpressions.function.utils.MyProductFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static String functionProduct(Product product) {
        return product.getName().toUpperCase();
    }

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        List<Product> products = new ArrayList<>();

        products.add(new Product("Tv", 900.00));
        products.add(new Product("Mouse", 50.00));
        products.add(new Product("Tablet", 350.0));
        products.add(new Product("HD Case", 80.90));

        List<String> names;

        Function<Product, String> function = p -> p.getName().toUpperCase();

        names = products.stream().map(new MyProductFunction()).collect(Collectors.toList());
        names.forEach(System.out::println);

        names = products.stream().map(Main::functionProduct).collect(Collectors.toList());
        names.forEach(System.out::println);

        names = products.stream().map(Product::functionProduct).collect(Collectors.toList());
        names.forEach(System.out::println);

        names = products.stream().map(function).collect(Collectors.toList());
        names.forEach(System.out::println);

        names = products.stream().map(p -> p.getName().toUpperCase()).collect(Collectors.toList());
        names.forEach(System.out::println);

    }
}
