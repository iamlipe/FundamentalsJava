package inheritanceAndPolymorphism.managerStore.entities;

public class ImportedProduct extends Product {
    private final Double customsFee;

    public ImportedProduct(String name, Double price, Double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    public Double totalPrice() {
        return price + customsFee;
    }

    @Override
    public String priceTag() {
        return String.format("$ %.2f (Customs fee: $ %.2f)", totalPrice(), customsFee);
    }
}
