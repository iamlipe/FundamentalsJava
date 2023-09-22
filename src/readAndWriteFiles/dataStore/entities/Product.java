package readAndWriteFiles.dataStore.entities;

public class Product {

    private final String name;
    private final Double price;
    private final Integer quantity;

    public Product(String name, Double price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    private double total() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return name + "," + total();
    }
}
