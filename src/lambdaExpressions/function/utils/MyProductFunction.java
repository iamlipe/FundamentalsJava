package lambdaExpressions.function.utils;

import lambdaExpressions.function.entities.Product;

import java.util.function.Function;

public class MyProductFunction implements Function<Product, String> {

    @Override
    public String apply(Product product) {
        return product.getName().toUpperCase();
    }
}
