package lambdaExpressions.predicate.utils;

import lambdaExpressions.predicate.entities.Product;

import java.util.function.Predicate;

public class MyProductPredicate implements Predicate<Product> {

    @Override
    public boolean test(Product product) {
        return product.getPrice() >= 100.0;
    }
}
