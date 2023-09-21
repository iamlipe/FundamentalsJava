package inheritanceAndPolymorphism.managerStore.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product {
    private final LocalDate manufactureDate;

    public UsedProduct(String name, Double price, LocalDate manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String priceTag() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return "(used) " +
                String.format("$ %.2f ", price) +
                "(Manufacture date: " +
                manufactureDate.format(formatter) +
                ")";
    }
}
