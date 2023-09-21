package inheritanceAndPolymorphism.managerStore.entities;

public class Product {
    private final String name;
    protected final Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String priceTag() {
        return String.format("$ %.2f", price);
    }
}
