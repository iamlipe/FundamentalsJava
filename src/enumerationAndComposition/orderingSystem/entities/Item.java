package enumerationAndComposition.orderingSystem.entities;

public class Item {
    private int quantity;
    private Product product;

    public Item() {
    }

    public Item(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double subTotal() {
        return quantity * product.getPrice();
    }

    @Override
    public String toString() {
        return product.getName() +
                ", " +
                String.format("$%.2f", product.getPrice()) +
                ", " +
                "Quantity: " +
                quantity +
                ", " +
                "Subtotal: " +
                String.format("$%.2f", subTotal());
    }
}
