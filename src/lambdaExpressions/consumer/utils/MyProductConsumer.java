package lambdaExpressions.consumer.utils;

import lambdaExpressions.consumer.entities.Product;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class MyProductConsumer implements Consumer<Product> {

    @Override
    public void accept(Product product) {
        product.setPrice(product.getPrice() * 1.1);
    }
}
